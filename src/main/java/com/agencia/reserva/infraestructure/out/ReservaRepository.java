package com.agencia.reserva.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class ReservaRepository implements ReservaServiceOlf {

    private Connection connection;

    public ReservaRepository() {

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
    public void createReservaAgente(Reserva reserva) {

        try {
            String query = "INSERT INTO reservaviaje (fecha,idvuelos,idclientes,estado) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, reserva.getFechaReserva());
            ps.setInt(2, reserva.getIdVuelo());
            ps.setInt(3, reserva.getIdCliente());
            ps.setString(4, "Confirmada");

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    reserva.setId(id);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservaAgente(Reserva reserva) {
        String query= "DELETE FROM reservaviaje where id=?" ;
        try (PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1, reserva.getId());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
           

    }

    

    @Override
    public Reserva findReservaAgente(int id) {
        String query = "SELECT r.id, r.fecha, v.precioviaje, v.idorigenaeropuerto, " +
                "v.iddestinoaeropuerto, c.nombre, c.numerodocumento, r.estado " +
                "FROM reservaviaje r " +
                "INNER JOIN viajes v ON v.id = r.idvuelos " +
                "INNER JOIN clientes c ON c.id = r.idclientes " +
                "WHERE r.id = ?";
        Reserva reserva = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva();
                    reserva.setId(rs.getInt("r.id"));
                    reserva.setFechaReserva(rs.getString("r.fecha"));
                    reserva.setPrecio(rs.getInt("v.precioviaje"));
                    reserva.setAeropuertoOrigen(rs.getString("v.idorigenaeropuerto"));
                    reserva.setAeropuertoDestino(rs.getString("v.iddestinoaeropuerto"));
                    reserva.setNombreCliente(rs.getString("c.nombre"));
                    reserva.setNumeroDocumento(rs.getString("c.numerodocumento"));
                    reserva.setEstado(rs.getString("r.estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;

    }

    @Override
    public void cancelReservaCliente(Reserva reserva) {
        String query= "UPDATE  reservaviaje SET estado=? WHERE id=?";
        try (PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(2, reserva.getId());
            ps.setString(1, "Cancelada");
            ps.executeUpdate();
            System.out.println("Reserva Cancelada con exito");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    // private boolean existeReserva(int id) {
    //     String query = "SELECT COUNT(*) FROM reservaviaje WHERE id = ?";
    //     try (PreparedStatement ps = connection.prepareStatement(query)) {
    //         ps.setInt(1, id);
    //         try (ResultSet rs = ps.executeQuery()) {
    //             if (rs.next()) {
    //                 return rs.getInt(1) > 0;
    //             }
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }
    
    
}
