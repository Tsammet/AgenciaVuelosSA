package com.agencia.reserva.application;

import java.util.List;

import com.agencia.reserva.domain.service.vueloService;

public class BuscarSillasOcupadas {
    private final vueloService vueloService;

    public BuscarSillasOcupadas(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }
    public List<String>  execute(int id)  {
     
        return vueloService.sillasVacias(id);
    }
}

