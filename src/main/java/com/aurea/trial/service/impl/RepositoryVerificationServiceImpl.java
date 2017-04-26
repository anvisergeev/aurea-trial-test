package com.aurea.trial.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurea.trial.domain.model.Repository;
import com.aurea.trial.service.GitService;
import com.aurea.trial.service.RepositoryVerificationService;
import com.aurea.trial.service.ServiceRuntimeException;

/**
 * Implementation of the repository verification service.
 *
 * @author aSergeev
 *
 */
@Service
public class RepositoryVerificationServiceImpl implements RepositoryVerificationService {

    @Autowired
    private GitService gitService;

    @Override
    public void verifyRepository(Repository repository) {

        File repositoryFolder = gitService.cloneRepository(repository);

        if (!repositoryFolder.exists()) {
            throw new ServiceRuntimeException("Repository source code is not found");
        }

    }
}
