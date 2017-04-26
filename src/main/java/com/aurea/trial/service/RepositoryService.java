package com.aurea.trial.service;

import java.util.List;

import com.aurea.trial.domain.model.Repository;

/**
 * Service for repositories management.
 *
 * @author aSergeev
 *
 */
public interface RepositoryService {

    /**
     * @return list of GitHub repositories.
     */
    List<Repository> getRepositories();

    /**
     * Creates new repository.
     *
     * @param name repository name
     * @param uri repository URI
     * @return new repository model
     */
    Repository createRepository(String name, String uri);

}
