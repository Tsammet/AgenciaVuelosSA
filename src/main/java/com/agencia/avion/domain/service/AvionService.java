package com.agencia.avion.domain.service;

import com.agencia.avion.domain.entity.Avion;

public interface AvionService {
    void createAvion(Avion avion);
    void updateAvion(Avion avion);
    Avion findAvion(int id);
    void deleteAvion(Avion avion);
    Avion deleteAvion(int id);
}
