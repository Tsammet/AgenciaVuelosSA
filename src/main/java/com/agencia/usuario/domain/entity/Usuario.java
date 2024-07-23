package com.agencia.usuario.domain.entity;

public class Usuario {
    private int id;
    private String usuario;
    private String contrasena;
    private int idrol;
    
    public Usuario() {
    }

    public Usuario(int id, String usuario, String contrasena, int idrol) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.idrol = idrol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String string) {
        this.usuario = string;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }


}
