
package com.agencia.aeropuerto.aplication;


import com.agencia.aeropuerto.domain.entity.Aeropuerto;
import com.agencia.aeropuerto.domain.service.AeropuertoService;

public class CreateAeropuertoCase {
    private final AeropuertoService aeropuertoService;

    public CreateAeropuertoCase(AeropuertoService aeropuertoService){
        this.aeropuertoService = aeropuertoService;
    }

    public void execute(Aeropuerto aeropuertos){

        aeropuertoService.createAeropuerto(aeropuertos);
    }

} 
