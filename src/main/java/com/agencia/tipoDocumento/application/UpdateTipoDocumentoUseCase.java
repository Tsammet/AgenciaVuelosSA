package com.agencia.tipoDocumento.application;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;

public class UpdateTipoDocumentoUseCase {
    private final TipoDocumentoService tipoDocumentoService;
    
    public UpdateTipoDocumentoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
    public void execute(TipoDocumento tipoDocumento){
        tipoDocumentoService.updateTipoDocumento(tipoDocumento);
    }
}
