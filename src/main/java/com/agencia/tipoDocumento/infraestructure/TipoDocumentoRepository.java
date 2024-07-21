package com.agencia.tipoDocumento.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;

public class TipoDocumentoRepository implements TipoDocumentoService {
    private Connection connection;

    public TipoDocumentoRepository() {

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
    public void createTipoDocumento(TipoDocumento tipoDocumento) {
        try {
            String query="INSERT INTO tiposdocumentos (nombre) VALUES (?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,tipoDocumento.getNombre());

            ps.executeUpdate();
            System.out.println("Tipo documento creado con exito!!");

            try (ResultSet generatedkeys=ps.getGeneratedKeys()){
                if (generatedkeys.next()) {
                    int id = generatedkeys.getInt(1);
                    tipoDocumento.setId(id);
                }
                
            }

          

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        

    @Override
    public void updateTipoDocumento(TipoDocumento tipoDocumento) { 
      String query="UPDATE tiposdocumentos SET nombre=? WHERE id=?";
      try (PreparedStatement ps=connection.prepareStatement(query)){

        ps.setString(1, tipoDocumento.getNombre());
        ps.setInt(2, tipoDocumento.getId());
        ps.executeUpdate();
        System.out.println("Tipo documento actualizado con éxito");
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }

     @Override
    public void deleteTipoDocumento(TipoDocumento tipoDocumento){
        String query ="DELETE  FROM tiposdocumentos WHERE id=? ";
        try (PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1,tipoDocumento.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    @Override
    public TipoDocumento findtipoDocumento(int id) {
        String query="SELECT id, nombre from tiposdocumentos where id=? ";
        TipoDocumento tipoDocumento=null;
        try (PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1, id);
            try (ResultSet rs =ps.executeQuery()){
                if(rs.next()){
                    tipoDocumento=new TipoDocumento();
                    tipoDocumento.setId(rs.getInt("id"));
                    tipoDocumento.setNombre(rs.getString("nombre"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tipoDocumento;
        
    }
       
}

    

   



