package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaService;

public class PagarValorReservaUseCase {

    private final ReservaService reservaServiceOlf;

    public PagarValorReservaUseCase(ReservaService reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }

    public void execute(Reserva reserva){
        reservaServiceOlf.pagarReserva(reserva);
    }

}