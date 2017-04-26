package com.aurea.trial.service;

import java.io.File;

import com.aurea.trial.domain.model.Repository;

/**
 * Service for communication with GitHub.
 *
 * @author aSergeev
 *
 */
public interface GitService {

    /**
     * Clones repository to local file system.
     *
     * @param repository repository to clone
     * @return folder with repository source code
     */
    File cloneRepository(Repository repository);

}
