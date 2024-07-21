package com.agencia.trayecto.application;

import com.agencia.trayecto.domain.entity.Trayecto;
import com.agencia.trayecto.domain.service.TrayectoService;

public class FindTrayectoUseCase {

    private final TrayectoService trayectoService;

    public FindTrayectoUseCase(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    public Trayecto execute (int id){
        return trayectoService.findTrayecto(id);
    }

    


}
