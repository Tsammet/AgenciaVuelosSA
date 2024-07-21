package com.agencia.tipoDocumento.application;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
//import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;

public class CreateTipoDocumentoUseCase {

    private final TipoDocumentoService tipoDocumentoService;
    
    public CreateTipoDocumentoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    
    }
    public void execute (TipoDocumento tipoDocumento){
        tipoDocumentoService.createTipoDocumento(tipoDocumento);
    }

    
   
}
