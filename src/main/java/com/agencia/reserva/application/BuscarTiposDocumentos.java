package com.agencia.reserva.application;

import java.util.List;

import com.agencia.reserva.domain.service.vueloService;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class BuscarTiposDocumentos {
    private final vueloService vueloService;

    public BuscarTiposDocumentos(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public List<TipoDocumento> execute() {
        return vueloService.buscarTipoDocumento();
    }
}
