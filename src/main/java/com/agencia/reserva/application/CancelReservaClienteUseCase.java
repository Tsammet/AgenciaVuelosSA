package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaService;

public class CancelReservaClienteUseCase {
    private final ReservaService reservaServiceOlf;
    
    public CancelReservaClienteUseCase(ReservaService reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
    public void execute(Reserva reserva){
        reservaServiceOlf.cancelReservaCliente(reserva);
    }

}