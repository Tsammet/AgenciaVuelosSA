package com.agencia.escala.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.agencia.escala.domain.entity.Escala;
import com.agencia.escala.domain.service.EscalaService;

public class EscalaRepository implements EscalaService {

    private Connection connection;

    // Genera conexion con el archivo resources/configdb.properties para hacer
    // conexion con la bd
    public EscalaRepository() {
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
    public List<Escala> findEscala(int idViaje) {

        List<Escala> escalas = new ArrayList<>();

        String query = "SELECT id, numeroconexion, idviaje, idavion, salidaidaeropuerto, llegadaidaeropuerto FROM conexionesvuelos WHERE idviaje = ?";
        Escala escala = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idViaje);
            try (ResultSet rs = ps.executeQuery()) {
                while  (rs.next()) {
                    escala = new Escala();
                    escala.setId(rs.getInt("id"));
                    escala.setNumeroConexion(rs.getString("numeroconexion"));
                    escala.setIdViaje(rs.getInt("idviaje"));
                    escala.setIdAvion(rs.getInt("idavion"));
                    escala.setIdAeropuertoOrigen(rs.getString("salidaidaeropuerto"));
                    escala.setIdAeropuertoDestino(rs.getString("llegadaidaeropuerto"));
                    escalas.add(escala);
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escalas;
    }

    @Override
    public void updateEscala(Escala escala) {

        String query = "UPDATE conexionesvuelos SET idavion = ?, salidaidaeropuerto = ?, llegadaidaeropuerto = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, escala.getIdAvion());
            ps.setString(2, escala.getIdAeropuertoOrigen());
            ps.setString(3, escala.getIdAeropuertoDestino());
            ps.setInt(4, escala.getId());
            ps.executeUpdate();

            System.out.println("<3");
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public Escala deleteEscala(int id) {

        String query = "Delete FROM conexionesvuelos WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void asignAvion(Escala escala){
        
        String query = "UPDATE conexionesvuelos SET idavion = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, escala.getIdAvion());
            ps.setInt(2, escala.getId());

            ps.executeUpdate();

            System.out.println("Avión asignado ");
        }catch(SQLException e ){
            e.printStackTrace();
        }
    
    }


}
