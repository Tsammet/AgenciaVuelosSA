package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.reserva.domain.service.vueloService;

public class FindvueloUseCase {
    private final vueloService vueloService;

    public FindvueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public vuelo execute(int id)  {
        return vueloService.findvuelo(id);
        
    }
}
