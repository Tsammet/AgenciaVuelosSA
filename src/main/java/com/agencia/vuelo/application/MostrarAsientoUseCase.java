package com.agencia.vuelo.application;

import java.util.List;

import com.agencia.asientos.domain.entity.Asiento;
import com.agencia.vuelo.domain.service.vueloService;

public class MostrarAsientoUseCase {

    private final vueloService vueloService;

    public MostrarAsientoUseCase(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public List<Asiento> execute(int id) {
        return vueloService.assignAsiento(id);
    }


    

}
