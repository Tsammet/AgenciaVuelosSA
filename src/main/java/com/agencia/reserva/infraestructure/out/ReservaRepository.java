
package com.agencia.reserva.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaService;

public class ReservaRepository implements ReservaService {

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
            String query = "INSERT INTO reservaviaje (fecha,idvuelos,idclientes) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, reserva.getFechaReserva());
            ps.setInt(2, reserva.getIdVuelo());
            ps.setInt(3, reserva.getIdCliente());

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

        try {
            String query = "INSERT INTO detallesreservaviaje (idreserva,idtarifa) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getId());
            ps.setInt(2, reserva.getIdtarifa());

            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reserva.setIdReservaDetalle(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void deleteReservaAgente(Reserva reserva) {
        String query = "DELETE FROM reservaviaje where id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, reserva.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Reserva findReservaAgente(int id) {
        String query = "SELECT rv.id, rv.fecha, rv.idclientes, cl.nombre, v.idorigenaeropuerto, v.iddestionaeropuerto, "
                +
                " tv.valor, rv.estado FROM reservaviaje as rv INNER JOIN detallesreservaviaje as drv " +
                "ON rv.id = drv.idreserva INNER JOIN tarifasvuelos as tv ON drv.idtarifa = tv.id " +
                "INNER JOIN viajes as v ON rv.idvuelos = v.id INNER JOIN clientes as cl " +
                "ON rv.idclientes = cl.id WHERE rv.id = ?";
        Reserva reserva = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva();
                    reserva.setId(rs.getInt("rv.id"));
                    reserva.setFechaReserva(rs.getString("rv.fecha"));
                    reserva.setPrecio(rs.getInt("tv.valor"));
                    reserva.setAeropuertoOrigen(rs.getString("v.idorigenaeropuerto"));
                    reserva.setAeropuertoDestino(rs.getString("v.iddestionaeropuerto"));
                    reserva.setNombreCliente(rs.getString("cl.nombre"));
                    reserva.setEstado(rs.getString("rv.estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;

    }

    @Override
    public void cancelReservaCliente(Reserva reserva) {
        String query = "UPDATE  reservaviaje SET estado=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(2, reserva.getId());
            ps.setString(1, "Cancelada");
            ps.executeUpdate();
            System.out.println("Reserva Cancelada con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
