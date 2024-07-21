package com.agencia.tarifa.domain.entity;

import java.math.BigDecimal;

public class Tarifa {
    private  int id;
    private  String descripcion;
    private  String detalles;
    private  BigDecimal  valor ;
    public Tarifa() {
    }
    public Tarifa(String descripcion, String detalles, BigDecimal valor) {
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.valor = valor;
    }
    public Tarifa(int id, String descripcion, String detalles, BigDecimal valor) {
        this.id = id;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.valor = valor;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
