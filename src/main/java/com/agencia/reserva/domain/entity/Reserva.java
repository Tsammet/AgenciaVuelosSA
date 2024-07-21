package com.agencia.reserva.domain.entity;

public class Reserva {
    private int id;
    private String fechaReserva;
    private int idVuelo;
    private int idCliente;
    private String estado;
    private int precio;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private String nombreCliente;
    private String numeroDocumento;
    public Reserva() {
    }
    
    public Reserva(int id, String fechaReserva, int idVuelo, int idCliente, String estado, int precio,
            String aeropuertoOrigen, String aeropuertoDestino, String nombreCliente, String numeroDocumento) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
        this.estado = estado;
        this.precio = precio;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.nombreCliente = nombreCliente;
        this.numeroDocumento = numeroDocumento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public int getIdVuelo() {
        return idVuelo;
    }
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
