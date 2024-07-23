package com.agencia.vuelo.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.domain.service.vueloService;

public class PagarValorReservaUseCase {

    private final vueloService vueloService;

    public PagarValorReservaUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public void execute(Reserva reserva){
        vueloService.pagarReserva(reserva);
    }

}