package com.agencia.revision.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.revision.domain.entity.Revision;
import com.agencia.revision.domain.service.RevisionService;

public class RevisionRepository implements RevisionService{
    private Connection connection;

    public RevisionRepository(){
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
    public void createRevision(Revision revision) {
        try{
            String query= "INSERT INTO revisiones (fecharevision, idavion) VALUES (?,?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,revision.getFechaRevision());
            ps.setInt(2,revision.getIdAvion());

            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    revision.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }

        try{
            String query= "INSERT INTO revisiondetalles (idrevision, descripcion, idempleado) VALUES (?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,revision.getId());

            ps.setString(2,revision.getDescripcion());
            ps.setInt(3,revision.getIdEmpleado());

            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    revision.setIdRevisionDetalle(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }


    }

    

    @Override
    public Revision findRevision(int id) {
        String query = "SELECT r.id, r.fecharevision, r.idavion, r2.descripcion, r2.idempleado "+ 
        " FROM revisiones r INNER JOIN revisiondetalles r2 " +
        " ON r.id = r2.idrevision INNER JOIN empleados e ON r2.idempleado = e.id WHERE r.id = ?";
        Revision revision = null;
        

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    revision = new Revision();
                    revision.setId(rs.getInt("r.id"));
                    revision.setFechaRevision(rs.getString("r.fecharevision"));
                    revision.setIdAvion(rs.getInt("r.idavion"));
                    revision.setDescripcion(rs.getString("r2.descripcion"));
                    revision.setIdEmpleado(rs.getInt("r2.idempleado"));
        
                
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revision;
    }

    @Override
    public void updateRevision(Revision revision) {

        try{
            String query = "UPDATE revisiones SET fecharevision = ?, idavion = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, revision.getFechaRevision());
            ps.setInt(2, revision.getIdAvion());
            ps.setInt(3, revision.getId());

            ps.executeUpdate();

            System.out.println("Revisión actualizada con éxito");
        }catch (SQLException e) {
            e.printStackTrace();

        }

        try{
            String query = "UPDATE revisiondetalles SET descripcion = ?, idempleado = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, revision.getDescripcion());
            ps.setInt(2, revision.getIdEmpleado());
            ps.setInt(3, revision.getId());

            ps.executeUpdate();

            System.out.println("!!!");
        }catch (SQLException e) {
            e.printStackTrace();

        }       


        
        
    }

     @Override
    public Revision deleteRevision(int id) {

        String query = "Delete FROM revisiones WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    

    


}
