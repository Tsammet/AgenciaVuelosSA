package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.service.vueloService;

public class VerificarPasajero {
    private final vueloService vueloService;

    public VerificarPasajero(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public int execute(Pasajero pasajero) {
         return vueloService.VerificarPasajero(pasajero);
}
}
