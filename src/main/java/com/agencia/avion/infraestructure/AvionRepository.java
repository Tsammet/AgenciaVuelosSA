package com.agencia.avion.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.domain.service.AvionService;

public class AvionRepository implements AvionService{
    private Connection connection;

    // Genera conexion con el archivo resources/configdb.properties para hacer conexion con la bd
    public AvionRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            System.out.println("URL: " + url); // Verificar la URL cargada
            System.out.println("User: " + user); // Verificar el usuario cargado
            // N
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");    
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createAvion(Avion avion) {
        
        try{
            String query= "INSERT INTO aviones (matricula,capacidad,fechafabricacion,idestado, idmodelo,idaerolinea) VALUES(?,?,?,?,?,?)";
            // Prepara la sentencia sql y genera el id autoincremental 
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,avion.getMatricula());
            ps.setInt(2,avion.getCapacidad());
            ps.setString(3,avion.getFechaFabricacion());
            ps.setInt(4,avion.getIdEstado());
            ps.setInt(5,avion.getIdModelo());
            ps.setInt(6,avion.getIdAerolinea());

            ps.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    avion.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }


    }

    @Override
    public void updateAvion(Avion avion) {

        String query = "UPDATE aviones SET matricula = ?,capacidad = ?,fechafabricacion = ? ,idestado = ?, idmodelo = ?,idaerolinea = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, avion.getMatricula());
            ps.setInt(2, avion.getCapacidad());
            ps.setString(3, avion.getFechaFabricacion());
            ps.setInt(4, avion.getIdEstado());
            ps.setInt(5, avion.getIdModelo());
            ps.setInt(6, avion.getIdAerolinea());
            ps.setInt(7, avion.getId());

            ps.executeUpdate();

            System.out.println("<3");
        }catch (SQLException e) {
            e.printStackTrace();

    }

    }

   
    @Override
    public Avion deleteAvion(int id) {

        String query = "Delete FROM aviones WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Avion findAvion(int id) {
        String query = "SELECT id, matricula, capacidad, fechaFabricacion, idEstado, idModelo, idAerolinea FROM aviones WHERE id = ?";
        Avion avion = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    avion = new Avion();
                    avion.setId(rs.getInt("id"));
                    avion.setMatricula(rs.getString("matricula"));
                    avion.setCapacidad(rs.getInt("capacidad"));
                    avion.setFechaFabricacion(rs.getString("fechaFabricacion"));
                    avion.setIdEstado(rs.getInt("idEstado"));
                    avion.setIdModelo(rs.getInt("idModelo"));
                    avion.setIdAerolinea(rs.getInt("idAerolinea"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avion;
    }

    @Override
    public void deleteAvion(Avion avion) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deleteAvion'");
    }
}

