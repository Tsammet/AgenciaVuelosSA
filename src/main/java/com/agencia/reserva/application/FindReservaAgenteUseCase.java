package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaService;

public class FindReservaAgenteUseCase {
    private final ReservaService reservaServiceOlf;
    
    public FindReservaAgenteUseCase(ReservaService reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
    
    public Reserva execute (int id){
        return reservaServiceOlf.findReservaAgente(id);

    }
}