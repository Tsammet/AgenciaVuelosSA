package com.agencia.reserva.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import java.awt.*;

import com.agencia.reserva.domain.entity.Asientosdetalles;
import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.entity.Ciudad;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.entity.VuelosDto;
import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.reserva.domain.service.vueloService;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
  public vuelo findvuelo(int id) {
    return null;

  }

  @Override
  public void updatevuelo(vuelo vuelo) {
    try {
      String sql = "UPDATE vuelosvuelos SET detalles = ?,descripcion=?,valor=? WHERE id = ?";

      PreparedStatement statement = connection.prepareStatement(sql);
      // statement.setString(1, vuelo.getDetalles());
      // statement.setString(2, vuelo.getDescripcion());
      // statement.setBigDecimal(3, vuelo.getValor());
      statement.setInt(4, vuelo.getId());
      int rowsUpdate = statement.executeUpdate();
      System.out.println("Numero de filas actualizadas  " + rowsUpdate);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public VuelosDto consultvuelo(int id) {

    VuelosDto vuelo = new VuelosDto();
    try {
      // String sql = "SELECT id, fechaviaje,
      // precioviaje,idorigenaeropuerto,iddestinoaeropuerto FROM viajes WHERE id = ?";
      String sql = "SELECT  v.id,v.precioviaje,v.fechaviaje ,a.nombre AS aeropuertoorigen,c.nombre AS ciudadorigen ,ad.nombre AS aeropuertodestino, cd.nombre AS ciudaddestino from viajes v       Join aeropuertos a       on a.id = v.idorigenaeropuerto       JOIN ciudades c       on a.idciudad =c.id      Join aeropuertos ad       on ad.id = v.iddestinoaeropuerto        JOIN ciudades cd       on ad.idciudad =cd.id      WHERE  v.id=?;";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setLong(1, id);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          vuelo.setId(resultSet.getInt("id"));
          vuelo.setFechaviaje(resultSet.getString("fechaviaje"));
          vuelo.setPrecioviaje((resultSet.getBigDecimal("precioviaje")));
          vuelo.setAeropuertoOrigen((resultSet.getString("aeropuertoorigen")));
          vuelo.setCiudadOrigen((resultSet.getString("ciudadorigen")));
          vuelo.setAeropuertoDestion((resultSet.getString("aeropuertodestino")));
          vuelo.setCiudadDestino((resultSet.getString("ciudaddestino")));
        }
        JOptionPane.showMessageDialog(null, "vuelo encontrada: \n" +
            "Fecha: " + vuelo.getFechaviaje() + "\n" +
            "Precio: " + vuelo.getPrecioviaje() + "\n" +
            "Aeropuerto Origen: " + vuelo.getAeropuertoOrigen() + "\n" +
            "Ciudad: " + vuelo.getCiudadOrigen() + "\n" +
            "Aeropuerto Destino: " + vuelo.getCiudadDestino() + "\n" +
            "Ciudad: " + vuelo.getCiudadDestino());

      } catch (SQLException e) {
        e.printStackTrace();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return vuelo;
  }

  @Override
  public void deletevuelo(int id) {
    try {
      String sql = "DELETE FROM vuelosvuelos WHERE id = ?";
      int rowsUpdate = 0;

      PreparedStatement statement = connection.prepareStatement(sql);

      statement.setInt(1, id);
      rowsUpdate = statement.executeUpdate();

      System.out.println("Número de filas eliminadas: " + rowsUpdate);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public List<String> BuscarVuelo(BuscarVuelo buscarVuelo) {

    String idAeropuertoOrigen = obtenerIdAeropuerto(buscarVuelo.getCiudadOrigen());
    String idAeropuertoDestino = obtenerIdAeropuerto(buscarVuelo.getCiudadDestino());
    buscarVuelo.setIdAeropuertoDestino(idAeropuertoDestino);
    buscarVuelo.setIdAeropuertoOrigen(idAeropuertoOrigen);
    System.out.println(buscarVuelo.getIdAeropuertoDestino());
    System.out.println(buscarVuelo.getIdAeropuertoOrigen());
    List<String> vuelos = new ArrayList<>();
    String sql = "SELECT id,precioviaje,fechaviaje from viajes v WHERE fechaviaje = ? AND  idorigenaeropuerto=? AND  iddestinoaeropuerto =?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, buscarVuelo.getFechaIda());
      statement.setString(2, buscarVuelo.getIdAeropuertoOrigen());
      statement.setString(3, buscarVuelo.getIdAeropuertoDestino());
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          vuelos.add(resultSet.getString("id"));

        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return vuelos;

  }

  class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String filePath) {
      try {
        backgroundImage = ImageIO.read(new File(filePath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void agregarPasajero(int idreserva) {
    JPanel panelBuscar = new JPanel(new GridLayout(0, 2));

    List<String> listTiposDocuemtnos = new ArrayList<>();
    String sql = "SELECT id,nombre FROM tiposdocumentos";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          listTiposDocuemtnos.add(resultSet.getString("nombre"));

        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    JComboBox<String> comboBoxTipoDocumento = new JComboBox<>(listTiposDocuemtnos.toArray(new String[0]));

    // JPanel panel = new JPanel(new GridLayout(0, 2));
    panelBuscar.add(new JLabel("Seleccione tipo Documento:"));
    panelBuscar.add(comboBoxTipoDocumento);
    JLabel documetoJLabel = new JLabel("Numero documento:");
    JTextField documentoField = new JTextField();
    panelBuscar.add(documetoJLabel);
    panelBuscar.add(documentoField);
    int result = JOptionPane.showConfirmDialog(null, panelBuscar, "Seleccionar tipo Documento",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    String tipoDocumento = null;
    if (result == JOptionPane.OK_OPTION) {
      tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
      System.out.println(tipoDocumento);
    }
    int idtipo = 0;
    try {
      String sqlIdTipos = "SELECT id FROM tiposdocumentos WHERE nombre = ? ";
      PreparedStatement statement = connection.prepareStatement(sqlIdTipos);
      statement.setString(1, tipoDocumento);

      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          idtipo = resultSet.getInt("id");
          System.out.println(idtipo);
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    Pasajero pasajero = null;
    try {
      String sqlPasajero = "SELECT id, nombre, idtipodocumento,numerodocumento,edad FROM    clientes WHERE numerodocumento = ? and idtipodocumento = ? ";

      PreparedStatement statement = connection.prepareStatement(sqlPasajero);
      statement.setString(1, documentoField.getText());
      statement.setInt(2, idtipo);

      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          pasajero = new Pasajero();
          pasajero.setId(resultSet.getInt("id"));
          pasajero.setNombre(resultSet.getString("nombre"));
          pasajero.setEdad(resultSet.getInt("edad"));
          pasajero.setIdTipoDocumento(resultSet.getInt("idtipodocumento"));
          pasajero.setDocumento(resultSet.getString("numerodocumento"));
          JPanel panelPasajero = new JPanel(new GridLayout(0, 1));

          JLabel nombreLabel = new JLabel("Nombre:" + pasajero.getNombre());
          panelPasajero.add(nombreLabel);
          JLabel edadLabel = new JLabel("edad:" + pasajero.getEdad());
          panelPasajero.add(edadLabel);
          JLabel tipoLabel = new JLabel("tipo documento:" + tipoDocumento);

          panelPasajero.add(tipoLabel);
          JLabel numeroLabel = new JLabel("numero documento:" + pasajero.getDocumento());

          panelPasajero.add(numeroLabel);
          int resulta = JOptionPane.showConfirmDialog(null, panelPasajero, "Seleccionar tipo Documento",
              JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        } else {

          JPanel panelPasajero = new JPanel(new GridLayout(0, 2));

          JLabel nombreLabel = new JLabel("Nombre:");
          JTextField nombreField = new JTextField();
          panelPasajero.add(nombreLabel);
          panelPasajero.add(nombreField);
          JLabel edadLabel = new JLabel("edad:");
          JTextField edadField = new JTextField();
          panelPasajero.add(edadLabel);
          panelPasajero.add(edadField);
          JLabel tipoLabel = new JLabel("tipo documento:");
          JLabel tipoDLabel = new JLabel(tipoDocumento);

          panelPasajero.add(tipoLabel);
          panelPasajero.add(tipoDLabel);

          JLabel numeroLabel = new JLabel("numero documento:");
          JLabel numeroDLabel = new JLabel(documentoField.getText());

          panelPasajero.add(numeroLabel);
          panelPasajero.add(numeroDLabel);

          int resulta = JOptionPane.showConfirmDialog(null, panelPasajero, "Seleccionar tipo Documento",
              JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
          pasajero = new Pasajero(nombreField.getText(), Integer.parseInt(edadField.getText()), idtipo,
              documentoField.getText());

          try {
            String query = "INSERT INTO clientes (nombre,edad,idtipodocumento,numerodocumento,rol) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query,
                PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setInt(2, pasajero.getEdad());
            ps.setInt(3, pasajero.getIdTipoDocumento());
            ps.setString(4, pasajero.getDocumento());
            ps.setInt(5, 2);

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
              if (generatedKeys.next()) {
                pasajero.setId(generatedKeys.getInt(1));
                System.out.println(pasajero.getId());
              }
            }
          } catch (SQLException e) {
            e.printStackTrace();

          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      String query = "INSERT INTO detallesreservaviaje (idreserva,idpasajero,idtarifa) VALUES (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);
      ps.setInt(1, idreserva);
      ps.setInt(2, pasajero.getId());
      ps.setInt(3, 1);

      ps.executeUpdate();

      try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          pasajero.setId(generatedKeys.getInt(1));
          System.out.println(pasajero.getId());
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }

    // // JPanel panel = new JPanel(new GridLayout(0, 2));
    // panel.add(new JLabel("Seleccione tipo Documento:"));
    // // panel.add(comboBoxTipoDocumento);
    // // JLabel documetoJLabel = new JLabel("Numero documento:");
    // // JTextField documentoField = new JTextField();
    // panel.add(documetoJLabel);
    // panel.add(documentoField);
    // int result = JOptionPane.showConfirmDialog(null, panel, "Seleccionar tipo
    // Documento", JOptionPane.OK_CANCEL_OPTION,
    // JOptionPane.PLAIN_MESSAGE);
    // String selectedTipoDocumento="";
    // int edadInt = Integer.parseInt(edadField.getText());
    // if (result == JOptionPane.OK_OPTION) {
    // selectedTipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
    // }
    // Pasajero pasajero = new Pasajero(nombreField.getText(), edadInt,
    // selectedTipoDocumento, documentoField.getText());

  }

  private String obtenerIdAeropuerto(String nombreCiudad) {
    String idAeropuerto = null;
    String sql = "SELECT a.id FROM aeropuertos a JOIN ciudades c ON c.id = a.idciudad WHERE c.nombre = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, nombreCiudad);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          idAeropuerto = resultSet.getString("id");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return idAeropuerto;
  }

  @Override
  public List<Ciudad> findAllCiudades() {
    List<Ciudad> ciudades = new ArrayList<>();
    String sql = "SELECT id, nombre FROM ciudades";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          Ciudad ciudad = new Ciudad();
          ciudad.setId(resultSet.getString("id"));
          ciudad.setCiudad(resultSet.getString("nombre"));
          ciudades.add(ciudad);
          System.out.println(ciudad.getCiudad());
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return ciudades;
  }

  @Override
  public int crearReserva(BuscarVuelo bvuelo) {
    int idreserva = 0;
    try {
      String query = "INSERT INTO reservaviaje (fecha,idvuelos,idclientes,estado) VALUES (?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);
      ps.setString(1, bvuelo.getFechaIda());
      ps.setInt(2, Integer.parseInt(bvuelo.getIdvuelo()));
      ps.setInt(3, 1);
      ps.setString(4, "reservado");

      ps.executeUpdate();
      System.out.println("hola");
      try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          idreserva = (generatedKeys.getInt(1));
          System.out.println(idreserva);
        }
      }
      System.out.println("adios");

    } catch (SQLException e) {
      e.printStackTrace();

    }
    return idreserva;
  }

  @Override
  public int VerificarPasajero(Pasajero pasajero) {
     int idPasajero = 0;
    String sqlPasajero = "SELECT c.id, c.nombre, c.idtipodocumento, c.numerodocumento, c.edad, t.nombre as tipodocumento " +
                         "FROM clientes c " +
                         "JOIN tiposdocumentos t ON c.idtipodocumento = t.id " +
                         "WHERE numerodocumento = ? AND idtipodocumento = ?";

    try (PreparedStatement statement = connection.prepareStatement(sqlPasajero)) {
        statement.setString(1, pasajero.getDocumento());
        statement.setInt(2, pasajero.getIdTipoDocumento());

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                pasajero.setId(resultSet.getInt("id"));
                pasajero.setNombre(resultSet.getString("nombre"));
                pasajero.setEdad(resultSet.getInt("edad"));
                pasajero.setIdTipoDocumento(resultSet.getInt("idtipodocumento"));
                pasajero.setDocumento(resultSet.getString("numerodocumento"));
                pasajero.setTipoDocumento(resultSet.getString("tipodocumento"));

                JPanel panelPasajero = new JPanel(new GridLayout(0, 1));
                panelPasajero.add(new JLabel("Nombre: " + pasajero.getNombre()));
                panelPasajero.add(new JLabel("Edad: " + pasajero.getEdad()));
                panelPasajero.add(new JLabel("Tipo Documento: " + pasajero.getTipoDocumento()));
                panelPasajero.add(new JLabel("Número Documento: " + pasajero.getDocumento()));

                int result = JOptionPane.showConfirmDialog(null, panelPasajero, "Detalles del Pasajero",
                                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    idPasajero = pasajero.getId();
                }
            } else {
                JPanel panelPasajero = new JPanel(new GridLayout(0, 2));
                panelPasajero.add(new JLabel("Nombre:"));
                JTextField nombreField = new JTextField();
                panelPasajero.add(nombreField);

                panelPasajero.add(new JLabel("Edad:"));
                JTextField edadField = new JTextField();
                panelPasajero.add(edadField);

                panelPasajero.add(new JLabel("Tipo Documento:"));
                panelPasajero.add(new JLabel(pasajero.getTipoDocumento()));

                panelPasajero.add(new JLabel("Número Documento:"));
                panelPasajero.add(new JLabel(pasajero.getDocumento()));

                int result = JOptionPane.showConfirmDialog(null, panelPasajero, "Nuevo Pasajero",
                                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    pasajero = new Pasajero(nombreField.getText(), Integer.parseInt(edadField.getText()),
                                            pasajero.getIdTipoDocumento(), pasajero.getDocumento());
                    // Add code to insert the new passenger into the database and retrieve the new id
                    // idPasajero = createNewPasajero(pasajero); // This should be a method to insert and return the new ID
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return idPasajero;
}

  @Override
  public List<TipoDocumento> buscarTipoDocumento() {
    List<TipoDocumento> listTipoDocumento = new ArrayList<>();
    String sql = "SELECT id,nombre FROM tiposdocumentos";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          TipoDocumento tipo = new TipoDocumento();
          tipo.setId(resultSet.getInt("id"));
          tipo.setNombre(resultSet.getString("nombre"));
          listTipoDocumento.add(tipo);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return listTipoDocumento;
  }

  @Override
  public void asignarsilla(Asientosdetalles asientosdetalles) {
    try {
      String query = "INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos,iddetallereserva,idasientos) VALUES (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);

      ps.setInt(1, asientosdetalles.getIdConexion());
      ps.setInt(2,  asientosdetalles.getIdDetalleReserva());
      ps.setInt(3,  asientosdetalles.getIdAsiento());

      ps.executeUpdate();

    
    } catch (SQLException e) {
      e.printStackTrace();

    }

  }

  @Override
  public int crearReservaDetalle(DetalleReserva detalleReserva) {
    int generatedId = -1; // Initialize with a default invalid value
    System.out.println(detalleReserva.getIdReserva());
    System.out.println(detalleReserva.getIdReserva());
    
    String query = "INSERT INTO detallesreservaviaje (idreserva, idpasajero) VALUES (?, ?)";

    try (PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
        ps.setInt(1, detalleReserva.getIdReserva());
        ps.setInt(2, detalleReserva.getIdPasajero());

        int affectedRows = ps.executeUpdate();

        if (affectedRows > 0) {
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                    detalleReserva.setId(generatedId);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return generatedId;
 }

  @Override
  public List<String> sillasVacias(int idConexion) {
    List<String> listasillas = new ArrayList<>();
    String sql = "                        SELECT idasientos FROM asientodetallereservaviajeconexion WHERE idconexionvuelos = ?;";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, idConexion);

      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          String silla = resultSet.getString("idasientos");
          listasillas.add(silla);
          System.out.println(silla);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return listasillas;
  }}
