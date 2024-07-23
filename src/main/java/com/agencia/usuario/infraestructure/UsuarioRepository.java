package com.agencia.usuario.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.usuario.domain.entity.Usuario;
import com.agencia.usuario.domain.service.UsuarioService;
import com.agencia.vuelo.domain.entity.Vuelos;

public class UsuarioRepository implements UsuarioService {

     private Connection connection;

    public UsuarioRepository() {
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

    // @Override
    // public void validarUsuario(usuario){

    //     Usuario usuario = null;
        
    //     try{
    //         String query= "SELECT id, usuario, contrasena FROM user";
    //         //Prepara la sentencia sql y genera el id autoincremental 
    //         PreparedStatement ps=connection.prepareStatement(query);

    //         // ps.setInt(1, id);
        
    //         try (ResultSet rs = ps.executeQuery()) {
    //             if (rs.next()) {
    //                 usuario = new Usuario();
    //                 usuario.setId(rs.getInt("id"));
    //                 usuario.setUsuario(rs.getString("usuario"));
    //                 usuario.setContrasena(rs.getString("contrasena"));

    //             }
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //         return usuario;

    // }



    @Override
    public Usuario validarUsuario(int id) {
        Usuario usuario = null;
        
        try {
            String query = "SELECT id, usuario, passw FROM user WHERE usuario = ? AND passw = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario user = new Usuario();
                    user.setId(rs.getInt("id"));
                    user.setUsuario(rs.getString("usuario"));
                    user.setContrasena(rs.getString("passw"));
                    
                    return user; // Devuelve el usuario encontrado
                } else {
                    System.out.println("USER NO ENCONTRADO");
                    return null; // No se encontró ningún usuario con esas credenciales
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Manejo básico de excepciones: imprime el error y devuelve null
        }
    }

    @Override
    public void validarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarUsuario'");
    }}




