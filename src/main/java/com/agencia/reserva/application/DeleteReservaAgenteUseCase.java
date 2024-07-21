package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class DeleteReservaAgenteUseCase {
    private final ReservaServiceOlf reservaServiceOlf;

    public DeleteReservaAgenteUseCase(ReservaServiceOlf reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
    public void execute(Reserva reserva){
        reservaServiceOlf.deleteReservaAgente(reserva);
    }
    
}
