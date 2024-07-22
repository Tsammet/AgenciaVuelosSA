package com.agencia.vuelo.application;

import com.agencia.asientos.domain.entity.AsientoDetalle;
import com.agencia.vuelo.domain.service.vueloService;

public class AsignarAsientoUseCase {

    private final vueloService vueloService;

    public AsignarAsientoUseCase(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }


    public void execute (AsientoDetalle asientoDetalle){
        vueloService.createAsientoDetalle(asientoDetalle);
    }

}
