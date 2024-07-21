package com.agencia.tarifa.application;

import com.agencia.tarifa.domain.entity.Tarifa;
import com.agencia.tarifa.domain.service.TarifaService;

public class FindTarifaUseCase {
    private final TarifaService tarifaService;

    public FindTarifaUseCase(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    public Tarifa execute(int id)  {
        return tarifaService.findTarifa(id);
        
    }
}
