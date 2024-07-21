package com.agencia.aeropuerto.aplication;

import com.agencia.aeropuerto.domain.entity.Aeropuerto;
import com.agencia.aeropuerto.domain.service.AeropuertoService;

public class UpdateAeropuertoCase {
    private final AeropuertoService aeropuertoService;

    public UpdateAeropuertoCase(AeropuertoService aeropuertoService){
        this.aeropuertoService = aeropuertoService;
    }
    public void execute(Aeropuerto aeropuerto){
        aeropuertoService.updateAeropuerto(aeropuerto);
    }
}
