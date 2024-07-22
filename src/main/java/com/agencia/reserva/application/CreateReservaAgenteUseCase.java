package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaService;

public class CreateReservaAgenteUseCase {
    private final ReservaService reservaServiceOlf;
    
    public CreateReservaAgenteUseCase(ReservaService reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }

    public void execute(Reserva reserva){
        reservaServiceOlf.createReservaAgente(reserva);
    }
}