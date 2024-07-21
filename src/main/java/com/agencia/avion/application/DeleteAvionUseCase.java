package com.agencia.avion.application;

import com.agencia.avion.domain.service.AvionService;

public class DeleteAvionUseCase {

    private final AvionService avionService;

    public DeleteAvionUseCase(AvionService avionService) {
        this.avionService = avionService;
    }

    public void execute(int id){
        avionService.deleteAvion(id);
    }

}   
