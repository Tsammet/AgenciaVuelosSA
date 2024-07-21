package com.agencia.revision.application;

import com.agencia.revision.domain.entity.Revision;
import com.agencia.revision.domain.service.RevisionService;

public class UpdateRevisionUseCase {

    private final RevisionService revisionService;

    public UpdateRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void execute(Revision revision){
        revisionService.updateRevision(revision);
    }

}
