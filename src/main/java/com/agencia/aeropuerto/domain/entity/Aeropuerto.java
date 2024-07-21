package com.agencia.aeropuerto.domain.entity;

public class Aeropuerto {
    private String id;    
    private String nombreae;
    private String idciudadae;
    public Aeropuerto(){
        
    }

    public Aeropuerto( String nombreae, String idciudadae) {
        this.nombreae = nombreae;
        this.idciudadae = idciudadae;
    }
    public Aeropuerto(String id, String nombreae, String idciudadae) {
        this.id = id;
        this.nombreae = nombreae;
        this.idciudadae = idciudadae;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombreae() {
        return nombreae;
    }
    public void setNombreae(String nombreae) {
        this.nombreae = nombreae;
    }
    public String getIdciudadae() {
        return idciudadae;
    }
    public void setIdciudadae(String idciudadae) {
        this.idciudadae = idciudadae;
    }
    

}
