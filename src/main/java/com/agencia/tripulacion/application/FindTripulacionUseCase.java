package com.agencia.tripulacion.application;

import com.agencia.tripulacion.domain.entity.Tripulacion;
import com.agencia.tripulacion.domain.service.TripulacionService;

public class FindTripulacionUseCase {

    private final TripulacionService tripulacionService;

    public FindTripulacionUseCase(TripulacionService tripulacionService) {
        this.tripulacionService = tripulacionService;
    }

    public Tripulacion execute(int id){
        return tripulacionService.findTripulacion(id);
    }

}
