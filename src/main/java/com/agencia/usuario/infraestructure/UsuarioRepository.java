package com.agencia.usuario.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.usuario.domain.entity.Usuario;
import com.agencia.usuario.domain.service.UsuarioService;

public class UsuarioRepository implements UsuarioService {

    private Connection connection;

    public UsuarioRepository() {
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
public Usuario validarUsuario(Usuario usuario) {
    Usuario usuarioValidado = null;
    
    try {
        String query = "SELECT id, usuario, passw, idrol FROM user WHERE usuario = ? AND passw = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getContrasena());
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int idRol = rs.getInt("idRol");
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("passw"));
                user.setIdrol(idRol);
                usuarioValidado = user;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return usuarioValidado;
}
}