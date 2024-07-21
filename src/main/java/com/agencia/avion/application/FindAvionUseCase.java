package com.agencia.avion.application;

import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.domain.service.AvionService;

public class FindAvionUseCase {

    private final AvionService avionService;

    public FindAvionUseCase(AvionService avionService) {
        this.avionService = avionService;
    }

    
    public Avion execute (int id){
        return  avionService.findAvion(id);

    }


}
