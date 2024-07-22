package com.agencia.asientos.domain.entity;

public class Asiento {

    private int id;
    private String numeroAsiento;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumeroAsiento() {
        return numeroAsiento;
    }
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Asiento() {

    }
    
    public Asiento(int id, String numeroAsiento) {
        this.id = id;
        this.numeroAsiento = numeroAsiento;
    }
    

    
}
