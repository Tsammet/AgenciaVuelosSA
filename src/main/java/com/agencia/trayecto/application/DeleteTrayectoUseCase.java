package com.agencia.trayecto.application;

import com.agencia.trayecto.domain.service.TrayectoService;

public class DeleteTrayectoUseCase {

    private final TrayectoService trayectoService;

    public DeleteTrayectoUseCase(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    public void execute(int id){
        trayectoService.deleteTrayecto(id);
    }


    

}
