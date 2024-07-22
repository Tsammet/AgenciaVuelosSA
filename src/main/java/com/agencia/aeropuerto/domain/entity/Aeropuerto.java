
package com.agencia.aeropuerto.domain.entity;

public class Aeropuerto {
    private String id;    
    private String nombreAero;
    private String idCiudad;
   
    public Aeropuerto() {
    }

    public Aeropuerto(String id, String nombreAero, String idCiudad) {
        this.id = id;
        this.nombreAero = nombreAero;
        this.idCiudad = idCiudad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreAero() {
        return nombreAero;
    }

    public void setNombreAero(String nombreAero) {
        this.nombreAero = nombreAero;
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    
    

}
