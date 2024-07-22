package com.agencia.vuelo.application;

import java.util.List;

import com.agencia.vuelo.domain.entity.Vuelos;
import com.agencia.vuelo.domain.service.vueloService;

public class SearchVueloxCiudadUseCase {

    public final vueloService vueloService;

    public SearchVueloxCiudadUseCase(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public List<Vuelos> execute(String ciudadOrigen, String ciudadDestino) {
        return vueloService.searchVueloxCiudad(ciudadOrigen, ciudadDestino);
    }

    
}
