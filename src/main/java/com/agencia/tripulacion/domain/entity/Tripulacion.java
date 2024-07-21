package com.agencia.tripulacion.domain.entity;

public class Tripulacion {

    private int idempleado;
    private int idconexion;

    public int getIdempleado() {
        return idempleado;
    }
    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
    public int getIdconexion() {
        return idconexion;
    }
    public void setIdconexion(int idconexion) {
        this.idconexion = idconexion;
    }

    public Tripulacion() {
    }

    public Tripulacion(int idempleado, int idconexion) {
        this.idempleado = idempleado;
        this.idconexion = idconexion;
    }

}
