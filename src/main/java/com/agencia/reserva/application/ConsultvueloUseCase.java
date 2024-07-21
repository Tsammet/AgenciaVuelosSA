package com.agencia.reserva.application;

import java.sql.SQLException;

import com.agencia.reserva.domain.entity.VuelosDto;
import com.agencia.reserva.domain.service.vueloService;

public class ConsultvueloUseCase {
    private final vueloService vueloService;

    public ConsultvueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public VuelosDto execute(int id) throws SQLException {
     
        return vueloService.consultvuelo(id);
    }
}
