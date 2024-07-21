package com.agencia.cliente.domain.entity;



public class Cliente {
    private int id;
    private String nombre;
    private int edad;
    private int idtipodocumento;
    private String numerodocumento;
    private String tipodocumento;
    private int rol;


    
    public Cliente(int id, String nombre, int edad, int idtipodocumento, String numerodocumento, String tipodocumento,
            int rol) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.idtipodocumento = idtipodocumento;
        this.numerodocumento = numerodocumento;
        this.tipodocumento = tipodocumento;
        this.rol = rol;
    }
    public Cliente(String nombre, int edad, int idtipodocumento, String numerodocumento, int rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.idtipodocumento = idtipodocumento;
        this.numerodocumento = numerodocumento;
        this.rol = rol;
    }
    public Cliente(int id, String nombre, int edad, int idtipodocumento, String numerodocumento, int rol) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.idtipodocumento = idtipodocumento;
        this.numerodocumento = numerodocumento;
        this.rol = rol;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getIdtipodocumento() {
        return idtipodocumento;
    }
    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }
    public String getNumerodocumento() {
        return numerodocumento;
    }
    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }
    public int getRol() {
        return rol;
    }
    public void setRol(int rol) {
        this.rol = rol;
    }
    public String getTipodocumento() {
        return tipodocumento;
    }
    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
    
}
