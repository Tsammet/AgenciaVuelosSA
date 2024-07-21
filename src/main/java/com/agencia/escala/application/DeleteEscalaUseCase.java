package com.agencia.escala.application;

import com.agencia.escala.domain.service.EscalaService;

public class DeleteEscalaUseCase {

    private final EscalaService escalaService;

    public DeleteEscalaUseCase(EscalaService escalaService) {
        this.escalaService = escalaService;
    }

    public void execute(int id){
        escalaService.deleteEscala(id);
    }

}
