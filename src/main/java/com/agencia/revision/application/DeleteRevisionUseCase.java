package com.agencia.revision.application;

import com.agencia.revision.domain.service.RevisionService;

public class DeleteRevisionUseCase {

    private final RevisionService revisionService;

    public DeleteRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void execute(int id){
        revisionService.deleteRevision(id);

    }

}
