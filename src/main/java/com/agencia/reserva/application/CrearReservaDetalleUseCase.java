package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.service.vueloService;

public class CrearReservaDetalleUseCase {
    private final vueloService vueloService;

    public CrearReservaDetalleUseCase(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }
    public int execute(DetalleReserva detalleReserva) {
    return vueloService.crearReservaDetalle(detalleReserva);
}
}
