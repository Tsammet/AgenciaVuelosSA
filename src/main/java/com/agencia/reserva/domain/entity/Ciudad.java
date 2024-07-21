package com.agencia.reserva.domain.entity;

public class Ciudad {
private String id;
private String ciudad;
public Ciudad() {
}
public Ciudad(String id, String ciudad) {
    this.id = id;
    this.ciudad = ciudad;
}
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getCiudad() {
    return ciudad;
}
public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
}
}
