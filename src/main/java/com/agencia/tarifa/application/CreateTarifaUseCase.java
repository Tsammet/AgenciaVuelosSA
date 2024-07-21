package com.agencia.tarifa.application;

import java.sql.SQLException;

import com.agencia.tarifa.domain.entity.Tarifa;
import com.agencia.tarifa.domain.service.TarifaService;

public class CreateTarifaUseCase {
    private final TarifaService tarifaService;

    public CreateTarifaUseCase(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    public void execute(Tarifa tarifas) throws SQLException {
     
        tarifaService.createTarifa(tarifas);
    }
}
