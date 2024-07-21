package com.agencia.avion.domain.entity;
public class Avion {
    private int id;
    private String matricula;
    private int capacidad;
    private String fechaFabricacion;
    private int idEstado;
    private int idModelo;
    private int idAerolinea;
    

    
    public Avion(String matricula, int capacidad, String fechaFabricacion, int idEstado, int idModelo,
            int idAerolinea) {
        //this.id = id;
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.fechaFabricacion = fechaFabricacion;
        this.idEstado = idEstado;
        this.idModelo = idModelo;
        this.idAerolinea = idAerolinea;
    }


    public Avion() {
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getFechaFabricacion() {
        return fechaFabricacion;
    }
    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public int getIdModelo() {
        return idModelo;
    }
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    public int getIdAerolinea() {
        return idAerolinea;
    }
    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
}
