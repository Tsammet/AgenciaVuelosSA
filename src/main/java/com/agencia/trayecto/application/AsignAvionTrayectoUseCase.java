package com.agencia.trayecto.application;

import com.agencia.trayecto.domain.entity.Trayecto;
import com.agencia.trayecto.domain.service.TrayectoService;

public class AsignAvionTrayectoUseCase {

    public final TrayectoService trayectoService;

    public AsignAvionTrayectoUseCase(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    public void execute(Trayecto trayecto){
        trayectoService.asignAvion(trayecto);
    }


}
     