package com.agencia.escala.domain.service;

import java.util.List;

import com.agencia.escala.domain.entity.Escala;

public interface EscalaService {

    List<Escala> findEscala(int idViaje);
    void updateEscala(Escala escala);
    Escala deleteEscala(int id);
    void asignAvion(Escala escala);

}