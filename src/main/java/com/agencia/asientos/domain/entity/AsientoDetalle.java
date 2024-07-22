package com.agencia.asientos.domain.entity;

public class AsientoDetalle {

    public int idConexion;
    public int idDetalleReserva;
    public int idAsientos;
    public int getIdConexion() {
        return idConexion;
    }
    public void setIdConexion(int idConexion) {
        this.idConexion = idConexion;
    }
    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }
    public void setIdDetalleReserva(int idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }
    public int getIdAsientos() {
        return idAsientos;
    }
    public void setIdAsientos(int idAsientos) {
        this.idAsientos = idAsientos;
    }
    public AsientoDetalle() {
    }
    public AsientoDetalle(int idConexion, int idDetalleReserva, int idAsientos) {
        this.idConexion = idConexion;
        this.idDetalleReserva = idDetalleReserva;
        this.idAsientos = idAsientos;
    }

}
