package com.agencia.tarifa.application;

import com.agencia.tarifa.domain.service.TarifaService;

public class DeleteTarifaUseCase {
    private final TarifaService tarifaService;

    public DeleteTarifaUseCase(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

        public void execute(int id)  {
        tarifaService.deleteTarifa(id);
    }

}
