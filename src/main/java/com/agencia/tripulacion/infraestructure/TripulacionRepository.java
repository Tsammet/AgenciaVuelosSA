package com.agencia.tripulacion.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.tripulacion.domain.entity.Tripulacion;
import com.agencia.tripulacion.domain.service.TripulacionService;

public class TripulacionRepository implements TripulacionService{

    private Connection connection;

    public TripulacionRepository() {
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
    public void createTripulacion (Tripulacion tripulacion){

        String query = "INSERT INTO tripulantes (idempleado, idconexion) VALUES (?,?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tripulacion.getIdempleado());
            ps.setInt(2, tripulacion.getIdconexion());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override 
    public Tripulacion findTripulacion (int id){
        
        String query = "SELECT idempleado, idconexion FROM tripulantes WHERE idconexion = ?";
        Tripulacion tripulacion = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    tripulacion = new Tripulacion();
                    tripulacion.setIdempleado(rs.getInt("idempleado"));
                    tripulacion.setIdconexion(rs.getInt("idconexion"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return tripulacion; 

    }

}
