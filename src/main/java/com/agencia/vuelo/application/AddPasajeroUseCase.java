package com.agencia.vuelo.application;

import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.vuelo.domain.service.vueloService;

public class AddPasajeroUseCase {

    private final vueloService vueloService;

    public AddPasajeroUseCase(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public void execute (DetalleReserva detalleReserva){
        vueloService.addPasajero(detalleReserva);
    }    

}
