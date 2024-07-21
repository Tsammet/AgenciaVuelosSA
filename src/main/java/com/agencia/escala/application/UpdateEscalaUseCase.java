package com.agencia.escala.application;

import com.agencia.escala.domain.entity.Escala;
import com.agencia.escala.domain.service.EscalaService;

public class UpdateEscalaUseCase {

    private final EscalaService escalaService;

    public UpdateEscalaUseCase(EscalaService escalaService) {
        this.escalaService = escalaService;
    }

    public void execute(Escala escala){
        escalaService.updateEscala(escala);
    }

}
