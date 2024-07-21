package com.agencia.revision.domain.service;

import com.agencia.revision.domain.entity.Revision;

public interface RevisionService {

    void createRevision(Revision revision);
    void updateRevision(Revision revision);
    Revision findRevision(int id);
    // void deleteRevision(Revision revision);
    Revision deleteRevision(int id);

}
