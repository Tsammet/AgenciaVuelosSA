package com.agencia.reserva.domain.entity;

import java.math.BigDecimal;

public class VuelosDto {
   private  int id;
    private  String fechaviaje;
    private  BigDecimal precioviaje;
    private  String  aeropuertoOrigen ;
    private  String  ciudadOrigen ;
    private  String  aeropuertoDestion ;
    private  String  ciudadDestino ;
    public VuelosDto() {
    }
    public VuelosDto(int id, String fechaviaje, BigDecimal precioviaje, String aeropuertoOrigen, String ciudadOrigen,
            String aeropuertoDestion, String ciudadDestino) {
        this.id = id;
        this.fechaviaje = fechaviaje;
        this.precioviaje = precioviaje;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.ciudadOrigen = ciudadOrigen;
        this.aeropuertoDestion = aeropuertoDestion;
        this.ciudadDestino = ciudadDestino;
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
    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }
    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }
    public String getAeropuertoDestion() {
        return aeropuertoDestion;
    }
    public void setAeropuertoDestion(String aeropuertoDestion) {
        this.aeropuertoDestion = aeropuertoDestion;
    }
    public String getCiudadDestino() {
        return ciudadDestino;
    }
    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

}
