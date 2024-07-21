package com.agencia.avion.application;

import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.domain.service.AvionService;

public class CreateAvionUseCase {

    private final AvionService avionService;

    public CreateAvionUseCase(AvionService avionService) {
        this.avionService = avionService;
    }

    public void execute (Avion avion){
        avionService.createAvion(avion);
    }

}
