package com.agencia.trayecto.domain.entity;

public class Trayecto {

    private int id;
    private String fechaViaje;
    private int precioViaje;
    private String idOrigenAeropuerto;
    private String idDestinoAeropuerto;

    public Trayecto() {
    }

    public Trayecto(int id, String fechaViaje, int precioViaje, String idOrigenAeropuerto, String idDestinoAeropuerto) {
        this.id = id;
        this.fechaViaje = fechaViaje;
        this.precioViaje = precioViaje;
        this.idOrigenAeropuerto = idOrigenAeropuerto;
        this.idDestinoAeropuerto = idDestinoAeropuerto;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaViaje() {
        return fechaViaje;
    }
    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }
    public int getPrecioViaje() {
        return precioViaje;
    }
    public void setPrecioViaje(int precioViaje) {
        this.precioViaje = precioViaje;
    }
    public String getIdOrigenAeropuerto() {
        return idOrigenAeropuerto;
    }
    public void setIdOrigenAeropuerto(String idOrigenAeropuerto) {
        this.idOrigenAeropuerto = idOrigenAeropuerto;
    }
    public String getIdDestinoAeropuerto() {
        return idDestinoAeropuerto;
    }
    public void setIdDestinoAeropuerto(String idDestinoAeropuerto) {
        this.idDestinoAeropuerto = idDestinoAeropuerto;
    }

}
