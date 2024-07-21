package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class CreateReservaAgenteUseCase {
    private final ReservaServiceOlf reservaServiceOlf;
    
    public CreateReservaAgenteUseCase(ReservaServiceOlf reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }

    public void execute(Reserva reserva){
        reservaServiceOlf.createReservaAgente(reserva);
    }
}
