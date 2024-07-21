package com.agencia.revision.application;

import com.agencia.revision.domain.entity.Revision;
import com.agencia.revision.domain.service.RevisionService;

public class FindRevisionUseCase {

    private final RevisionService revisionService;

    public FindRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public Revision execute(int id){
        return revisionService.findRevision(id);
    }



}
