package com.agencia.aeropuerto.aplication;

import com.agencia.aeropuerto.domain.service.AeropuertoService;

public class DeleteAeropuertoCase {
    private final AeropuertoService aeropuertoService;

    public DeleteAeropuertoCase(AeropuertoService aeropuertoService){
        this.aeropuertoService = aeropuertoService;
    }

    public void execute(String id){
        aeropuertoService.deleteAeropuerto(id);
    }

}
