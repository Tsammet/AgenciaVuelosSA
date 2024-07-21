package com.agencia.reserva.domain.service;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public interface ReservaServiceOlf {
    void createReservaAgente (Reserva reserva);
    void deleteReservaAgente (Reserva reserva);
    Reserva findReservaAgente(int id);
    void cancelReservaCliente (Reserva reserva);

}
