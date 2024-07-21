package com.agencia.tarifa.domain.service;


import com.agencia.tarifa.domain.entity.Tarifa;

public interface TarifaService {

    void createTarifa(Tarifa tarifa);
    void updateTarifa(Tarifa tarifa);
    Tarifa findTarifa(int id);
    void deleteTarifa(int id);
}
