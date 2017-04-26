package com.aurea.trial.service;

import com.aurea.trial.domain.model.Repository;

/**
 * Service for repository verification.
 *
 * @author aSergeev
 *
 */
public interface RepositoryVerificationService {

    /**
     * Verifies repository consistency.
     * 
     * @param repository repository to verify
     */
    void verifyRepository(Repository repository);

}
