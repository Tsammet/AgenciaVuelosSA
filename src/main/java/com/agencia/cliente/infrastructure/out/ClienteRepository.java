package com.agencia.cliente.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.cliente.domain.entity.Cliente;
import com.agencia.cliente.domain.service.ClienteService;

public class ClienteRepository implements ClienteService {

    private Connection connection;

    public ClienteRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getEdad());
            ps.setInt(3, cliente.getIdtipodocumento());
            ps.setString(4, cliente.getNumerodocumento());
            ps.setInt(5, cliente.getRol());

            ps.executeUpdate();
            System.out.println("Cliente creado con éxito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCliente(Cliente cliente) {
        try {
            String sql = "UPDATE clientes SET nombre = ?, edad = ?, idtipodocumento = ?, numerodocumento = ?, rol = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setInt(2, cliente.getEdad());
            statement.setInt(3, cliente.getIdtipodocumento());
            statement.setString(4, cliente.getNumerodocumento());
            statement.setInt(5, cliente.getRol());
            statement.setInt(6, cliente.getId());

            int rowsUpdate = statement.executeUpdate();
            System.out.println("Cliente actualizado: " + rowsUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente findCliente(int id) {
        Cliente cliente = null;
        try {
            String sql = "SELECT c.id, c.nombre, c.edad, c.idtipodocumento, c.numerodocumento, c.rol, td.nombre AS nombre_tipodocumento " +
                         "FROM clientes c " +
                         "INNER JOIN tiposdocumentos td ON c.idtipodocumento = td.id " +
                         "WHERE c.id = ?";
    
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        cliente = new Cliente(id, sql, id, id, sql, id);
                        cliente.setId(resultSet.getInt("id"));
                        cliente.setNombre(resultSet.getString("nombre"));
                        cliente.setEdad(resultSet.getInt("edad"));
                        cliente.setIdtipodocumento(resultSet.getInt("idtipodocumento"));
                        cliente.setNumerodocumento(resultSet.getString("numerodocumento"));
                        cliente.setTipodocumento(resultSet.getString("nombre_tipodocumento"));
                   
                        cliente.setRol(resultSet.getInt("rol"));
                                            }
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void deleteCliente(int id) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            System.out.println("Número de filas eliminadas: " + rowsDeleted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
