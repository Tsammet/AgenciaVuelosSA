package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.service.vueloService;

public class CrearReservaUseCase {
    private final vueloService vueloService;

    public CrearReservaUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }
    
    public int execute(BuscarVuelo bvuelo) {
    return vueloService.crearReserva(bvuelo);
}
}
