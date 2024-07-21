package com.agencia.reserva.domain.entity;

import java.math.BigDecimal;

public class vuelo {
    private  int id;
    private  String fechaviaje;
    private  BigDecimal precioviaje;
    private  String  idorigen ;
    private  String  iddestino ;
    public vuelo() {
    }
    public vuelo(int id, String fechaviaje, BigDecimal precioviaje, String idorigen, String iddestino) {
        this.id = id;
        this.fechaviaje = fechaviaje;
        this.precioviaje = precioviaje;
        this.idorigen = idorigen;
        this.iddestino = iddestino;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaviaje() {
        return fechaviaje;
    }
    public void setFechaviaje(String fechaviaje) {
        this.fechaviaje = fechaviaje;
    }
    public BigDecimal getPrecioviaje() {
        return precioviaje;
    }
    public void setPrecioviaje(BigDecimal precioviaje) {
        this.precioviaje = precioviaje;
    }
    public String getIdorigen() {
        return idorigen;
    }
    public void setIdorigen(String idorigen) {
        this.idorigen = idorigen;
    }
    public String getIddestino() {
        return iddestino;
    }
    public void setIddestino(String iddestino) {
        this.iddestino = iddestino;
    }

  
}
