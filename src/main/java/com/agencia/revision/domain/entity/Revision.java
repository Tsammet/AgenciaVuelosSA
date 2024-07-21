package com.agencia.revision.domain.entity;


public class Revision {
    private int id;
    private int idRevisionDetalle;
    private String fechaRevision;
    private int idAvion;
    private String descripcion;
    private int idEmpleado;
    
    
    public Revision() {
    }


    public Revision(int id, int idRevisionDetalle, String fechaRevision, int idAvion, String descripcion,
            int idEmpleado) {
        this.id = id;
        this.idRevisionDetalle = idRevisionDetalle;
        this.fechaRevision = fechaRevision;
        this.idAvion = idAvion;
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getIdRevisionDetalle() {
        return idRevisionDetalle;
    }


    public void setIdRevisionDetalle(int idRevisionDetalle) {
        this.idRevisionDetalle = idRevisionDetalle;
    }


    public String getFechaRevision() {
        return fechaRevision;
    }


    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }


    public int getIdAvion() {
        return idAvion;
    }


    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getIdEmpleado() {
        return idEmpleado;
    }


    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


 


   
}
