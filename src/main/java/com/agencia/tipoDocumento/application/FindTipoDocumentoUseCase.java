package com.agencia.tipoDocumento.application;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;

public class FindTipoDocumentoUseCase {
    private final TipoDocumentoService tipoDocumentoService;

    public FindTipoDocumentoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    public TipoDocumento execute (int id){
        return tipoDocumentoService.findtipoDocumento(id);
    }
}
