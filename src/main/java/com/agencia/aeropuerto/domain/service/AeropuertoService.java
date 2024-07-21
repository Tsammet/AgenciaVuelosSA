package com.agencia.aeropuerto.domain.service;

import com.agencia.aeropuerto.domain.entity.Aeropuerto;;

public interface AeropuertoService {

    void createAeropuerto(Aeropuerto aeropuerto);
    void updateAeropuerto(Aeropuerto aeropuerto);
    Aeropuerto finAeropuerto(String id);
    void deleteAeropuerto(String id);


}
