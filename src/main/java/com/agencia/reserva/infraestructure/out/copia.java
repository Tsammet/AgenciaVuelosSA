package com.agencia.reserva.infraestructure.out;

// package com.agencia.vuelo.infraestructure.out;

// import java.io.File;
// import java.io.IOException;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.List;

// import javax.imageio.ImageIO;
// import javax.swing.BorderFactory;
// import javax.swing.ButtonGroup;
// import javax.swing.JComboBox;
// import javax.swing.JComponent;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JRadioButton;
// import javax.swing.JTextField;

// import com.agencia.vuelo.domain.entity.BuscarVuelo;
// import com.agencia.vuelo.domain.entity.Ciudad;
// import com.agencia.vuelo.domain.entity.Pasajero;
// import com.toedter.calendar.JCalendar;

// public class copia {

//   @Override
//   public void BuscarVuelo(List<Ciudad> ciudades) {
//     List<String> nombres = new ArrayList<>();
//     for (Ciudad ciudad : ciudades) {
//       nombres.add(ciudad.getCiudad());
//     }

//     JComboBox<String> comboBoxCiudadesorigen = new JComboBox<>(nombres.toArray(new String[0]));
//     JComboBox<String> comboBoxCiudadesdestino = new JComboBox<>(nombres.toArray(new String[0]));

//     JPanel panel = new JPanel(new GridLayout(0, 2));
//     panel.add(new JLabel("Seleccione una ciudad origen:"));
//     panel.add(comboBoxCiudadesorigen);
//     panel.add(new JLabel("Seleccione una ciudad destino:"));
//     panel.add(comboBoxCiudadesdestino);

//     int result = JOptionPane.showConfirmDialog(null, panel, "Seleccionar Ciudad origen y destino",
//         JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//     if (result == JOptionPane.OK_OPTION) {
//       String selectedCiudadorigen = (String) comboBoxCiudadesorigen.getSelectedItem();
//       String selectedCiudaddestino = (String) comboBoxCiudadesdestino.getSelectedItem();
//       System.out.println("Ciudad origen seleccionada: " + selectedCiudadorigen);
//       System.out.println("Ciudad destino seleccionada: " + selectedCiudaddestino);

//       JCalendar calendar = new JCalendar();
//       JPanel panelc = new JPanel(new GridLayout(0, 2));
//       panelc.add(new JLabel("Seleccione una fecha:"));
//       panelc.add(calendar);

//       int resultc = JOptionPane.showConfirmDialog(null, panelc, "Seleccionar Fecha", JOptionPane.OK_CANCEL_OPTION,
//           JOptionPane.PLAIN_MESSAGE);
//       if (resultc == JOptionPane.OK_OPTION) {
//         Date selectedDate = calendar.getDate();
//         Calendar cal = Calendar.getInstance();
//         cal.setTime(selectedDate);
//         int dia = cal.get(Calendar.DAY_OF_MONTH);
//         int mes = cal.get(Calendar.MONTH) + 1; // Los meses comienzan en 0 en Calendar, por lo que se añade 1
//         int año = cal.get(Calendar.YEAR);
//         String fechaida = año + "-" + mes + "-" + dia;
//         System.out.println(fechaida);

//         String idAeropuertoOrigen = obtenerIdAeropuerto(selectedCiudadorigen);
//         String idAeropuertoDestino = obtenerIdAeropuerto(selectedCiudaddestino);

//         System.out.println("ID Aeropuerto Origen: " + idAeropuertoOrigen);
//         System.out.println("ID Aeropuerto Destino: " + idAeropuertoDestino);

//         BuscarVuelo bvuelo = new BuscarVuelo(fechaida, idAeropuertoOrigen, idAeropuertoDestino);
//         vuelofecha(bvuelo);

//       } else {
//         System.out.println("Selección de fecha cancelada");
//       }
//     } else {
//       System.out.println("Selección de ciudades cancelada");
//     }
//   }

//   private void vuelofecha(BuscarVuelo bvuelo) {
//     System.out.println(bvuelo.getIdAeropuertoDestino());
//     System.out.println(bvuelo.getIdAeropuertoOrigen());
//     List<String> vuelos = new ArrayList<>();
//     String sql = "SELECT id,precioviaje,fechaviaje from viajes v WHERE fechaviaje = ? AND  idorigenaeropuerto=? AND  iddestinoaeropuerto =?";

//     try (PreparedStatement statement = connection.prepareStatement(sql)) {
//       statement.setString(1, bvuelo.getFechaIda());
//       statement.setString(2, bvuelo.getIdAeropuertoOrigen());
//       statement.setString(3, bvuelo.getIdAeropuertoDestino());
//       try (ResultSet resultSet = statement.executeQuery()) {
//         while (resultSet.next()) {
//           vuelos.add(resultSet.getString("id"));

//         }
//       } catch (SQLException e) {
//         e.printStackTrace();
//       }
//       System.out.println(vuelos);
//       JComboBox<String> comboBoxVuelos = new JComboBox<>(vuelos.toArray(new String[0]));

//       JPanel panel = new JPanel(new GridLayout(0, 2));
//       panel.add(new JLabel("Seleccione Vuelo:"));
//       panel.add(comboBoxVuelos);

//       int resultVuelo = JOptionPane.showConfirmDialog(null, panel, "Seleccionar vuelo", JOptionPane.OK_CANCEL_OPTION,
//           JOptionPane.PLAIN_MESSAGE);
//       String selectVuelo = "0";
//       if (resultVuelo == JOptionPane.OK_OPTION) {
//         selectVuelo = (String) comboBoxVuelos.getSelectedItem();
//         System.out.println(selectVuelo);
//       }

//       var yesOrNo = 0;
//       int idreserva;
//       while (yesOrNo == 0) {
//         try {
//           String query = "INSERT INTO reservaviaje (fecha,idvuelos,idclientes,estado) VALUES (?,?,?,?)";
//           PreparedStatement ps = connection.prepareStatement(query,
//               PreparedStatement.RETURN_GENERATED_KEYS);
//           ps.setString(1, bvuelo.getFechaIda());
//           ps.setInt(2, Integer.parseInt(selectVuelo));
//           ps.setInt(3, 1);
//           ps.setString(4, "reservado");

//           ps.executeUpdate();
        
//           try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//             if (generatedKeys.next()) {
//               idreserva = generatedKeys.getInt(1);
//               agregarPasajero(idreserva);
//             }
//           }
//         } catch (SQLException e) {
//           e.printStackTrace();

//         }
        
//         yesOrNo = JOptionPane.showConfirmDialog(null, "Desea agregar un nuevo pasajero?");

//       }
//       if (yesOrNo == 1) {
//         JOptionPane.showMessageDialog(null, "Selecciona silla");
//       }


      
//       // try (ResultSet resultSet = statement.executeQuery()) {
//       // if (resultSet.next()) {
//       // int id = resultSet.getInt("id");
//       // BigDecimal precio = resultSet.getBigDecimal("precioviaje");
//       // JOptionPane.showMessageDialog(null, "vuelo encontrada:" +id +" \n" +
//       // "Fecha: " + bvuelo.getFechaIda() + "\n" +
//       // "Precio: " + precio + "\n" +
//       // "Aeropuerto Origen: " +bvuelo.getIdAeropuertoOrigen() + "\n" +
//       // "Aeropuerto Destino: " +bvuelo.getIdAeropuertoDestino() + "\n"
//       // );

//       // }else{
//       // JOptionPane.showMessageDialog(null, " no se encontro vuelo" );
//       // }
//       // }

//     } catch (SQLException e) {
//       e.printStackTrace();
//     }

// seleccionarSilla();
//     // JPanel panel = new ImagePanel("src\\main\\resources\\avion.png");
        
//     // panel.setLayout(new GridLayout(6, 10));
//     // // Crear un array para almacenar los botones de opción
//     // JRadioButton[][] options = new JRadioButton[6][10];
//     // ButtonGroup group = new ButtonGroup();

//     // // Rellenar el panel con botones de opción
//     // for (int row = 0; row < 6; row++) {
//     //     for (int col = 0; col < 10; col++) {
//     //         options[row][col] = new JRadioButton("Silla "+ (row * 10 + col + 1));
//     //         group.add(options[row][col]);
//     //         panel.add(options[row][col]);
//     //         if (row == 0 && col == 9) {
//     //           options[row][col].setEnabled(false);
//     //       }
//     //     }
        
//     // }

//     // // Mostrar el cuadro de diálogo con el panel
//     // int result = JOptionPane.showConfirmDialog(null, panel, "Selecciona una opción",
//     //         JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//     // // Procesar la selección del usuario
//     // if (result == JOptionPane.OK_OPTION) {
//     //     for (int row = 0; row < 6; row++) {
//     //         for (int col = 0; col < 10; col++) {
//     //             if (options[row][col].isSelected()) {
//     //                 System.out.println("Seleccionaste: " + options[row][col].getText());
//     //             }
//     //         }
//     //     }
//     // } else {
//     //     System.out.println("Operación cancelada.");
//     // }
// }
// class ImagePanel extends JPanel {
//   private Image backgroundImage;

//   public ImagePanel(String filePath) {
//       try {
//           backgroundImage = ImageIO.read(new File(filePath));
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
//   }
// }

//   private void agregarPasajero(int idreserva) {
//     JPanel panelBuscar = new JPanel(new GridLayout(0, 2));

//     List<String> listTiposDocuemtnos = new ArrayList<>();
//     String sql = "SELECT nombre FROM tiposdocumentos";
//     try (PreparedStatement statement = connection.prepareStatement(sql)) {
//       try (ResultSet resultSet = statement.executeQuery()) {
//         while (resultSet.next()) {
//           listTiposDocuemtnos.add(resultSet.getString("nombre"));

//         }
//       } catch (SQLException e) {
//         e.printStackTrace();
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }

//     JComboBox<String> comboBoxTipoDocumento = new JComboBox<>(listTiposDocuemtnos.toArray(new String[0]));

//     // JPanel panel = new JPanel(new GridLayout(0, 2));
//     panelBuscar.add(new JLabel("Seleccione tipo Documento:"));
//     panelBuscar.add(comboBoxTipoDocumento);
//     JLabel documetoJLabel = new JLabel("Numero documento:");
//     JTextField documentoField = new JTextField();
//     panelBuscar.add(documetoJLabel);
//     panelBuscar.add(documentoField);
//     int result = JOptionPane.showConfirmDialog(null, panelBuscar, "Seleccionar tipo Documento",
//         JOptionPane.OK_CANCEL_OPTION,
//         JOptionPane.PLAIN_MESSAGE);
//     String tipoDocumento = null;
//     if (result == JOptionPane.OK_OPTION) {
//       tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
//       System.out.println(tipoDocumento);
//     }
//     int idtipo = 0;
//     try {
//       String sqlIdTipos = "SELECT id FROM tiposdocumentos WHERE nombre = ? ";
//       PreparedStatement statement = connection.prepareStatement(sqlIdTipos);
//       statement.setString(1, tipoDocumento);

//       try (ResultSet resultSet = statement.executeQuery()) {
//         if (resultSet.next()) {
//           idtipo = resultSet.getInt("id");
//           System.out.println(idtipo);
//         }

//       } catch (SQLException e) {
//         e.printStackTrace();
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     Pasajero pasajero = null;
//     try {
//       String sqlPasajero = "SELECT id, nombre, idtipodocumento,numerodocumento,edad FROM    clientes WHERE numerodocumento = ? and idtipodocumento = ? ";

//       PreparedStatement statement = connection.prepareStatement(sqlPasajero);
//       statement.setString(1, documentoField.getText());
//       statement.setInt(2, idtipo);

//       try (ResultSet resultSet = statement.executeQuery()) {
//         if (resultSet.next()) {
//           pasajero = new Pasajero();
//           pasajero.setId(resultSet.getInt("id"));
//           pasajero.setNombre(resultSet.getString("nombre"));
//           pasajero.setEdad(resultSet.getInt("edad"));
//           pasajero.setIdTipoDocumento(resultSet.getInt("idtipodocumento"));
//           pasajero.setDocumento(resultSet.getString("numerodocumento"));
//           JPanel panelPasajero = new JPanel(new GridLayout(0, 1));

//           JLabel nombreLabel = new JLabel("Nombre:" + pasajero.getNombre());
//           panelPasajero.add(nombreLabel);
//           JLabel edadLabel = new JLabel("edad:" + pasajero.getEdad());
//           panelPasajero.add(edadLabel);
//           JLabel tipoLabel = new JLabel("tipo documento:" + tipoDocumento);

//           panelPasajero.add(tipoLabel);
//           JLabel numeroLabel = new JLabel("numero documento:" + pasajero.getDocumento());

//           panelPasajero.add(numeroLabel);
//           int resulta = JOptionPane.showConfirmDialog(null, panelPasajero, "Seleccionar tipo Documento",
//               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//         } else {

//           JPanel panelPasajero = new JPanel(new GridLayout(0, 2));

//           JLabel nombreLabel = new JLabel("Nombre:");
//           JTextField nombreField = new JTextField();
//           panelPasajero.add(nombreLabel);
//           panelPasajero.add(nombreField);
//           JLabel edadLabel = new JLabel("edad:");
//           JTextField edadField = new JTextField();
//           panelPasajero.add(edadLabel);
//           panelPasajero.add(edadField);
//           JLabel tipoLabel = new JLabel("tipo documento:");
//           JLabel tipoDLabel = new JLabel(tipoDocumento);

//           panelPasajero.add(tipoLabel);
//           panelPasajero.add(tipoDLabel);

//           JLabel numeroLabel = new JLabel("numero documento:");
//           JLabel numeroDLabel = new JLabel(documentoField.getText());

//           panelPasajero.add(numeroLabel);
//           panelPasajero.add(numeroDLabel);

//           int resulta = JOptionPane.showConfirmDialog(null, panelPasajero, "Seleccionar tipo Documento",
//               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//           pasajero = new Pasajero(nombreField.getText(), Integer.parseInt(edadField.getText()), idtipo,
//               documentoField.getText());

//           try {
//             String query = "INSERT INTO clientes (nombre,edad,idtipodocumento,numerodocumento,rol) VALUES (?,?,?,?,?)";
//             PreparedStatement ps = connection.prepareStatement(query,
//                 PreparedStatement.RETURN_GENERATED_KEYS);
//             ps.setString(1, pasajero.getNombre());
//             ps.setInt(2, pasajero.getEdad());
//             ps.setInt(3, pasajero.getIdTipoDocumento());
//             ps.setString(4, pasajero.getDocumento());
//             ps.setInt(5, 2);

//             ps.executeUpdate();

//             try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//               if (generatedKeys.next()) {
//                 pasajero.setId(generatedKeys.getInt(1));
//                 System.out.println(pasajero.getId());
//               }
//             }
//           } catch (SQLException e) {
//             e.printStackTrace();

//           }
//         }
//       } catch (SQLException e) {
//         e.printStackTrace();
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }

//     try {
//       String query = "INSERT INTO detallesreservaviaje (idreserva,idpasajero,idtarifa) VALUES (?,?,?)";
//       PreparedStatement ps = connection.prepareStatement(query,
//           PreparedStatement.RETURN_GENERATED_KEYS);
//       ps.setInt(1,idreserva);
//       ps.setInt(2, pasajero.getId());
//       ps.setInt(3, 1);

//       ps.executeUpdate();

//       try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//         if (generatedKeys.next()) {
//           pasajero.setId(generatedKeys.getInt(1));
//           System.out.println(pasajero.getId());
//         }
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();

//     }



//     // // JPanel panel = new JPanel(new GridLayout(0, 2));
//     // panel.add(new JLabel("Seleccione tipo Documento:"));
//     // // panel.add(comboBoxTipoDocumento);
//     // // JLabel documetoJLabel = new JLabel("Numero documento:");
//     // // JTextField documentoField = new JTextField();
//     // panel.add(documetoJLabel);
//     // panel.add(documentoField);
//     // int result = JOptionPane.showConfirmDialog(null, panel, "Seleccionar tipo
//     // Documento", JOptionPane.OK_CANCEL_OPTION,
//     // JOptionPane.PLAIN_MESSAGE);
//     // String selectedTipoDocumento="";
//     // int edadInt = Integer.parseInt(edadField.getText());
//     // if (result == JOptionPane.OK_OPTION) {
//     // selectedTipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
//     // }
//     // Pasajero pasajero = new Pasajero(nombreField.getText(), edadInt,
//     // selectedTipoDocumento, documentoField.getText());

//   }

//   private String obtenerIdAeropuerto(String nombreCiudad) {
//     String idAeropuerto = null;
//     String sql = "SELECT a.id FROM aeropuertos a JOIN ciudades c ON c.id = a.idciudad WHERE c.nombre = ?";
//     try (PreparedStatement statement = connection.prepareStatement(sql)) {
//       statement.setString(1, nombreCiudad);
//       try (ResultSet resultSet = statement.executeQuery()) {
//         if (resultSet.next()) {
//           idAeropuerto = resultSet.getString("id");
//         }
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return idAeropuerto;
//   }

//   @Override
//   public List<Ciudad> findAllCiudades() {
//     List<Ciudad> ciudades = new ArrayList<>();
//     String sql = "SELECT id, nombre FROM ciudades";

//     try (PreparedStatement statement = connection.prepareStatement(sql)) {
//       try (ResultSet resultSet = statement.executeQuery()) {
//         while (resultSet.next()) {
//           Ciudad ciudad = new Ciudad();
//           ciudad.setId(resultSet.getString("id"));
//           ciudad.setCiudad(resultSet.getString("nombre"));
//           ciudades.add(ciudad);
//           System.out.println(ciudad.getCiudad());
//         }
//       } catch (SQLException e) {
//         e.printStackTrace();
//       }
//     } catch (Exception e) {
//       e.printStackTrace();
//     }

//     return ciudades;
//   }






// public void seleccionarSilla() {
//   JPanel optionsPanel = new JPanel(new GridLayout(6, 15));
//   optionsPanel.setOpaque(false); 
//   optionsPanel.setBackground(Color.black);
//   JRadioButton[][] options = new JRadioButton[6][20];
//   ButtonGroup group = new ButtonGroup();
//   char c = 'A';
//   for (int row = 0; row < 6; row++) {
//       for (int col = 0; col < 20; col++) {
          
//           options[row][col] = new JRadioButton(Character.toString(c) + ( col + 1));
//           // options[row][col].setOpaque(false); 
//           options[row][col].setBackground(Color.gray);

//           options[row][col].setForeground(Color.green);

//           group.add(options[row][col]);
//           optionsPanel.add(options[row][col]);

//           if (row == 0 && col == 9) {
              
//               options[row][col].setEnabled(false);
//               options[row][col].setOpaque(true); 

//               // options[row][col].setBackground(Color.red);


//           }
//       }
//       c++;
//   }

//   // Crear el panel principal que contendrá el panel de opciones
//   JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // Margen de 10 píxeles
//   mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes alrededor del panel principal
//   mainPanel.setOpaque(false); // Hacer el panel principal transparente
//   mainPanel.add(optionsPanel, BorderLayout.CENTER);

//   // Crear el cuadro de diálogo con un panel de fondo con imagen
//   BackgroundPanel backgroundPanel = new BackgroundPanel(mainPanel, "src\\main\\resources\\avion.png"); // Cambia esta ruta a la ruta de tu imagen
//   JOptionPane.showMessageDialog(null, backgroundPanel, "Selecciona una opción", JOptionPane.PLAIN_MESSAGE);

//   // Procesar la selección del usuario
//   for (int row = 0; row < 6; row++) {
//       for (int col = 0; col < 10; col++) {
//           if (options[row][col].isSelected()) {
//               System.out.println("Seleccionaste: " + options[row][col].getText());
//           }
//       }
//   }
// }


// class BackgroundPanel extends JPanel {
// private Image backgroundImage;
// private JComponent component;

// public BackgroundPanel(JComponent component, String filePath) {
//   this.component = component;
//   try {
//       backgroundImage = ImageIO.read(new File(filePath));
//   } catch (IOException e) {
//       e.printStackTrace();
//   }
//   setLayout(new GridBagLayout());
//   add(component);
// }

// @Override
// protected void paintComponent(Graphics g) {
//   super.paintComponent(g);
//   if (backgroundImage != null) {
//       int imgWidth = backgroundImage.getWidth(this);
//       int imgHeight = backgroundImage.getHeight(this);
//       int x = (getWidth() - imgWidth) / 2;
//       int y = (getHeight() - imgHeight) / 2;
//       g.drawImage(backgroundImage, x, y, imgWidth, imgHeight, this);
//   }
// }

// @Override
// public Dimension getPreferredSize() {
//   if (backgroundImage != null) {
//       return new Dimension(1200, 700);
//   } else {
//       return super.getPreferredSize();
//   }
// }
// }}

// }
