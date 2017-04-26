package com.aurea.trial.service.impl;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aurea.trial.domain.model.Repository;
import com.aurea.trial.service.GitService;
import com.aurea.trial.service.ServiceRuntimeException;

/**
 * Implementation of the service for communication with GitHub.
 *
 * @author aSergeev
 *
 */
@Service
public class GitServiceImpl implements GitService {

    @Value("${gitService.targetRootFolderPath}")
    private String targetRootFolderPath;

    @Override
    public File cloneRepository(Repository repository) {

        File targetFolder =
                new File(targetRootFolderPath + File.separatorChar + repository.getName());
        try {
            Git.cloneRepository().setURI(repository.getUri()).setDirectory(targetFolder).call();
        } catch (GitAPIException ex) {
            throw new ServiceRuntimeException("Unable to clone GIT repository", ex);
        }

        return targetFolder;
    }

}
