package com.agencia.vuelo.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.agencia.asientos.domain.entity.Asiento;
import com.agencia.asientos.domain.entity.AsientoDetalle;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.domain.entity.Vuelos;
import com.agencia.vuelo.domain.service.vueloService;

public class vueloRepository implements vueloService {

    private Connection connection;

    public vueloRepository() {
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
public Vuelos findVuelo(int id) {
    String query = "SELECT id, fechaviaje, precioviaje, idorigenaeropuerto, iddestionaeropuerto FROM viajes WHERE id = ?";
    
    Vuelos vuelo = null;
    
    
    try (PreparedStatement ps = connection.prepareStatement(query)) {
        
        ps.setInt(1, id);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                vuelo = new Vuelos();
                vuelo.setId(rs.getInt("id"));
                vuelo.setFechaviaje(rs.getString("fechaviaje"));
                vuelo.setPrecioviaje(rs.getBigDecimal("precioviaje"));
                vuelo.setIdorigen(rs.getString("idorigenaeropuerto"));
                vuelo.setIddestino(rs.getString("iddestionaeropuerto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return vuelo;

  }

  public List<Vuelos> searchVueloxCiudad(String ciudadOrigen, String ciudadDestino){
    
    List<Vuelos> vuelos = new ArrayList<>();

    String query = "SELECT id, fechaviaje, precioviaje, idorigenaeropuerto, iddestionaeropuerto FROM viajes WHERE idorigenaeropuerto = ? and iddestionaeropuerto = ?";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        
      ps.setString(1, ciudadOrigen);
      ps.setString(2, ciudadDestino);
      
      try (ResultSet rs = ps.executeQuery()) {
          while (rs.next()) {
              Vuelos vuelo = new Vuelos();
              vuelo.setId(rs.getInt("id"));
              vuelo.setFechaviaje(rs.getString("fechaviaje"));
              vuelo.setPrecioviaje(rs.getBigDecimal("precioviaje"));
              vuelo.setIdorigen(rs.getString("idorigenaeropuerto"));
              vuelo.setIddestino(rs.getString("iddestionaeropuerto"));
              vuelos.add(vuelo);
          }
        } 
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
      return vuelos;

  }

@Override
public void createReserva(Reserva reserva) {
  try{

    String query = "INSERT INTO reservaviaje (fecha, idvuelos, idclientes) VALUES (?,?,?)";
    
    PreparedStatement ps=connection.prepareStatement(query,
    PreparedStatement.RETURN_GENERATED_KEYS);

    ps.setString(1, reserva.getFechaReserva());
    ps.setInt(2, reserva.getIdVuelo());
    ps.setInt(3, reserva.getIdCliente());

    ps.executeUpdate();

    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
      if (generatedKeys.next()) {
          reserva.setId(generatedKeys.getInt(1));
      }
  }
  }catch(SQLException e){
    e.printStackTrace();

  }

}

  public void addPasajero(DetalleReserva detalleReserva){
    try{

      String query = "INSERT INTO detallesreservaviaje (idreserva, idpasajero, idtarifa) VALUES (?,?,?)";
      
      PreparedStatement ps=connection.prepareStatement(query,
      PreparedStatement.RETURN_GENERATED_KEYS);
  
      ps.setInt(1, detalleReserva.getIdReserva());
      ps.setInt(2, detalleReserva.getIdPasajero());
      ps.setInt(3, detalleReserva.getIdTarifa());
  
      ps.executeUpdate();
  
      ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            detalleReserva.setId(generatedKeys.getInt(1));
        }
    
    }catch (SQLIntegrityConstraintViolationException e) {
        System.out.println("Error de integridad de la clave externa: " + e.getMessage());
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }  

  @Override
  public List<Asiento> assignAsiento(int id) {
    List<Asiento> asientos = new ArrayList<>();

    String query = "SELECT id, numeroasiento FROM asientos";
    try (PreparedStatement ps = connection.prepareStatement(query)) {
    
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Asiento asiento = new Asiento();
            asiento.setId(rs.getInt("id"));
            asiento.setNumeroAsiento(rs.getString("numeroasiento"));
            asientos.add(asiento);
        }
    }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return asientos;
}

@Override
public void createAsientoDetalle(AsientoDetalle asientoDetalle) {
  try{

    String query = "INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos, iddetallereserva, idasientos) VALUES (?,?,?)";
    
    PreparedStatement ps=connection.prepareStatement(query);

    ps.setInt(1, asientoDetalle.getIdConexion());
    ps.setInt(2, asientoDetalle.getIdDetalleReserva());
    ps.setInt(3, asientoDetalle.getIdAsientos());

    ps.executeUpdate();

  }catch(SQLException e){
    e.printStackTrace();

  }

}


}


  




