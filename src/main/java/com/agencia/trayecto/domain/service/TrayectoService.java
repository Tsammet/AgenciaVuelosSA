package com.agencia.trayecto.domain.service;

import com.agencia.trayecto.domain.entity.Trayecto;

public interface TrayectoService {

    Trayecto findTrayecto(int id);
    void updateTrayecto(Trayecto trayecto);
    void deleteTrayecto(Trayecto trayecto);
    Trayecto deleteTrayecto(int id);
    void asignAvion (Trayecto trayecto);
    void asignTripulacion(Trayecto trayecto);


}
