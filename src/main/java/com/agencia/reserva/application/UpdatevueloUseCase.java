package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.reserva.domain.service.vueloService;

public class UpdatevueloUseCase {
    private final vueloService vueloService;

    public UpdatevueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }
    public void execute(vuelo vuelo)  {
        vueloService.updatevuelo(vuelo);
    }
}
