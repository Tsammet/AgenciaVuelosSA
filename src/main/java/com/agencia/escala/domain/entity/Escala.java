package com.agencia.escala.domain.entity;

public class Escala {
    private int id;
    private String numeroConexion;
    private int idViaje;
    private int idAvion;
    private String idAeropuertoOrigen;
    private String idAeropuertoDestino;


    public Escala() {
    }


    public Escala(int id, String numeroConexion, int idViaje, int idAvion, String idAeropuertoOrigen,
            String idAeropuertoDestino) {
        this.id = id;
        this.numeroConexion = numeroConexion;
        this.idViaje = idViaje;
        this.idAvion = idAvion;
        this.idAeropuertoOrigen = idAeropuertoOrigen;
        this.idAeropuertoDestino = idAeropuertoDestino;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNumeroConexion() {
        return numeroConexion;
    }


    public void setNumeroConexion(String numeroConexion) {
        this.numeroConexion = numeroConexion;
    }


    public int getIdViaje() {
        return idViaje;
    }


    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    public int getIdAvion() {
        return idAvion;
    }


    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }


    public String getIdAeropuertoOrigen() {
        return idAeropuertoOrigen;
    }


    public void setIdAeropuertoOrigen(String idAeropuertoOrigen) {
        this.idAeropuertoOrigen = idAeropuertoOrigen;
    }


    public String getIdAeropuertoDestino() {
        return idAeropuertoDestino;
    }


    public void setIdAeropuertoDestino(String idAeropuertoDestino) {
        this.idAeropuertoDestino = idAeropuertoDestino;
    }


    

}
