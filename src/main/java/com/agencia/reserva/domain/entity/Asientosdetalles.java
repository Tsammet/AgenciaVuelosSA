package com.agencia.reserva.domain.entity;

public class Asientosdetalles {
int idConexion;
int idDetalleReserva;
int idAsiento;
public Asientosdetalles(int idConexion, int idDetalleReserva, int idAsiento) {
    this.idConexion = idConexion;
    this.idDetalleReserva = idDetalleReserva;
    this.idAsiento = idAsiento;
}
public Asientosdetalles() {
}
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
public int getIdAsiento() {
    return idAsiento;
}
public void setIdAsiento(int sillaseleccionada) {
    this.idAsiento = sillaseleccionada;
}

}
