package com.agencia.tripulacion.application;

import com.agencia.tripulacion.domain.entity.Tripulacion;
import com.agencia.tripulacion.domain.service.TripulacionService;

public class CreateTripulacionUseCase {

    public final TripulacionService tripulacionService;

    public CreateTripulacionUseCase(TripulacionService tripulacionService) {
        this.tripulacionService = tripulacionService;
    }

    public void execute(Tripulacion tripulacion){
        tripulacionService.createTripulacion(tripulacion);
    }

}
