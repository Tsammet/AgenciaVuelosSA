package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.entity.Vuelos;
import com.agencia.vuelo.domain.service.vueloService;
import com.agencia.vuelo.infraestructure.vueloRepository;

public class PagarValorReservaUseCase {

    private final vueloService vueloService;

    public PagarValorReservaUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public void execute(Vuelos vuelo){
        vueloService.pagarReserva(vuelo);
    }

}