package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaService;

public class DeleteReservaAgenteUseCase {
    private final ReservaService reservaServiceOlf;

    public DeleteReservaAgenteUseCase(ReservaService reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
    public void execute(Reserva reserva){
        reservaServiceOlf.deleteReservaAgente(reserva);
    }
    
}