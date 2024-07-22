package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.entity.Vuelos;
import com.agencia.vuelo.domain.service.vueloService;

public class FindvueloUseCase {
    private final vueloService vueloService;

    public FindvueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public Vuelos execute(int id)  {
        return vueloService.findVuelo(id);
        
    }
}
