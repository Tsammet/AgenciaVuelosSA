package com.agencia.tarifa.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.tarifa.domain.entity.Tarifa;
import com.agencia.tarifa.domain.service.TarifaService;

public class TarifaRepository implements TarifaService {

  private Connection connection;

  public TarifaRepository() {
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
  public void createTarifa(Tarifa tarifa) {
    try {
      String query = "INSERT INTO tarifasvuelos (descripcion,detalles,valor) VALUES (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);
      ps.setString(1, tarifa.getDescripcion());
      ps.setString(2, tarifa.getDetalles());
      ps.setBigDecimal(3, tarifa.getValor());

      ps.executeUpdate();
      System.out.println("Tarifa creada con éxito!");
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }

  @Override
  public void updateTarifa(Tarifa tarifa) {
    try {
      String sql = "UPDATE tarifasvuelos SET detalles = ?,descripcion=?,valor=? WHERE id = ?";

      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, tarifa.getDetalles());
      statement.setString(2, tarifa.getDescripcion());
      statement.setBigDecimal(3, tarifa.getValor());
      statement.setInt(4, tarifa.getId());
      int rowsUpdate = statement.executeUpdate();
      System.out.println("Numero de filas actualizadas  " + rowsUpdate);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Tarifa findTarifa(int id) {
    Tarifa tarifa = null;
    try {
      String sql = "SELECT id, detalles, descripcion,valor FROM tarifasvuelos WHERE id = ?";

      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setLong(1, id);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          tarifa = new Tarifa();
          tarifa.setId(resultSet.getInt("id"));
          tarifa.setDescripcion(resultSet.getString("detalles"));
          tarifa.setDetalles(resultSet.getString("descripcion"));
          tarifa.setValor(resultSet.getBigDecimal("valor"));
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return tarifa;
  }

  @Override
  public void deleteTarifa(int id) {
    try{
    String sql = "DELETE FROM tarifasvuelos WHERE id = ?";
        int rowsUpdate = 0;
    
             PreparedStatement statement = connection.prepareStatement(sql) ;
    
            statement.setInt(1, id);
            rowsUpdate = statement.executeUpdate();
    
            System.out.println("Número de filas eliminadas: " + rowsUpdate);
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

}}
