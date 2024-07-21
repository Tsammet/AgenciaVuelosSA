package com.agencia.tripulacion.domain.service;

import com.agencia.tripulacion.domain.entity.Tripulacion;

public interface TripulacionService {

    void createTripulacion(Tripulacion tripulacion);
    Tripulacion findTripulacion (int id);

}
