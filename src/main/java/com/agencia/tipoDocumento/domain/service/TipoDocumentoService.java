package com.agencia.tipoDocumento.domain.service;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public interface TipoDocumentoService {
    void createTipoDocumento(TipoDocumento tipoDocumento);
    void updateTipoDocumento(TipoDocumento tipoDocumento);
    TipoDocumento findtipoDocumento(int id);
    void deleteTipoDocumento(TipoDocumento tipoDocumento);

}
