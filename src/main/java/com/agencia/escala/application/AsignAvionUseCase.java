package com.agencia.escala.application;

import com.agencia.escala.domain.entity.Escala;
import com.agencia.escala.domain.service.EscalaService;

public class AsignAvionUseCase {

    public final EscalaService escalaService;

    public AsignAvionUseCase(EscalaService escalaService) {
        this.escalaService = escalaService;
    }

    public void execute(Escala escala){
        escalaService.asignAvion(escala);
    }

    public void execute(int idEscalaAvion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
