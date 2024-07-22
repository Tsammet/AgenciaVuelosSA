package com.agencia.vuelo.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.domain.service.vueloService;

public class CreateReservaxClienteUseCase {

    private final vueloService vueloService;

    public CreateReservaxClienteUseCase(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public void execute (Reserva reserva){
        vueloService.createReserva(reserva);
    }


    
}
