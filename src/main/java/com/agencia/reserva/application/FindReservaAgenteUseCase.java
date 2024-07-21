package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class FindReservaAgenteUseCase {
    private final ReservaServiceOlf reservaServiceOlf;
    
    public FindReservaAgenteUseCase(ReservaServiceOlf reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
    
    public Reserva execute (int id){
        return reservaServiceOlf.findReservaAgente(id);

    }
}
