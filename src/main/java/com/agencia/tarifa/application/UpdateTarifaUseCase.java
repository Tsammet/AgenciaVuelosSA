package com.agencia.tarifa.application;

import com.agencia.tarifa.domain.entity.Tarifa;
import com.agencia.tarifa.domain.service.TarifaService;

public class UpdateTarifaUseCase {
    private final TarifaService tarifaService;

    public UpdateTarifaUseCase(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }
    public void execute(Tarifa tarifa)  {
        tarifaService.updateTarifa(tarifa);
    }
}
