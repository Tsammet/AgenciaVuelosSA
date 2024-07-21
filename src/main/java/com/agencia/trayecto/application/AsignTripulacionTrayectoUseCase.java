package com.agencia.trayecto.application;

import com.agencia.trayecto.domain.entity.Trayecto;
import com.agencia.trayecto.domain.service.TrayectoService;

public class AsignTripulacionTrayectoUseCase {

    public final TrayectoService trayectoService;

    public AsignTripulacionTrayectoUseCase(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }
    
    public void execute(Trayecto trayecto){
        trayectoService.asignTripulacion(trayecto);
    }


}
