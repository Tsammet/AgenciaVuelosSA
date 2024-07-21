package com.agencia.revision.application;

import com.agencia.revision.domain.entity.Revision;
import com.agencia.revision.domain.service.RevisionService;

public class CreateRevisionUseCase {

    private final RevisionService revisionService;

    public CreateRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void execute (Revision revision){
        revisionService.createRevision(revision);
    }

    
}
