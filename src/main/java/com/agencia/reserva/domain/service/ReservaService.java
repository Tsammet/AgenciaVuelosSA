package com.agencia.reserva.domain.service;

import com.agencia.reserva.domain.entity.Reserva;

public interface ReservaService {
    void createReservaAgente (Reserva reserva);
    void deleteReservaAgente (Reserva reserva);
    Reserva findReservaAgente(int id);
    void cancelReservaCliente (Reserva reserva);
    void pagarReserva (Reserva reserva);

}