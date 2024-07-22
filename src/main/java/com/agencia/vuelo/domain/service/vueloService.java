package com.agencia.vuelo.domain.service;


import java.util.List;

import com.agencia.asientos.domain.entity.Asiento;
import com.agencia.asientos.domain.entity.AsientoDetalle;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.domain.entity.Vuelos;

public interface vueloService {

    Vuelos findVuelo(int id);    
    List<Vuelos> searchVueloxCiudad(String ciudadOrigen, String ciudadDestino);
    void createReserva(Reserva reserva);
    void addPasajero(DetalleReserva detalleReserva);
    List<Asiento> assignAsiento(int id);
    void createAsientoDetalle(AsientoDetalle asientoDetalle);
    void pagarReserva(Reserva reserva);

}
