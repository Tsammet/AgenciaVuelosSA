package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class CancelReservaClienteUseCase {
    private final ReservaServiceOlf reservaServiceOlf;
    
    public CancelReservaClienteUseCase(ReservaServiceOlf reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
    public void execute(Reserva reserva){
        reservaServiceOlf.cancelReservaCliente(reserva);
    }

}
