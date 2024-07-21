package com.agencia.trayecto.application;

import com.agencia.trayecto.domain.entity.Trayecto;
import com.agencia.trayecto.domain.service.TrayectoService;

public class UpdateTrayectoUseCase {

    private final TrayectoService trayectoService;

    public UpdateTrayectoUseCase(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    public void execute (Trayecto trayecto){
        trayectoService.updateTrayecto(trayecto);
    }

}
