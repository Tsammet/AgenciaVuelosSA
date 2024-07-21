package com.agencia.aeropuerto.aplication;

import com.agencia.aeropuerto.domain.entity.Aeropuerto;
import com.agencia.aeropuerto.domain.service.AeropuertoService;

public class FindAeropuertoCase {
    private final AeropuertoService aeropuertoService;

    public FindAeropuertoCase(AeropuertoService aeropuertoService){
        this.aeropuertoService = aeropuertoService;
    }

    public Aeropuerto execute(String idaeropuerto){
        return aeropuertoService.finAeropuerto(idaeropuerto);
    }

}
