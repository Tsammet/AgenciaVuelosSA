package com.agencia.avion.application;

import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.domain.service.AvionService;

public class UpdateAvionUseCase {

    private final AvionService avionService;

    public UpdateAvionUseCase(AvionService avionService) {
        this.avionService = avionService;
    }

    public void execute(Avion avion){
        avionService.updateAvion(avion);
    }

}
