package com.aurea.trial.service;

import java.util.Map;

import com.aurea.trial.domain.model.Repository;

/**
 * Service for messaging delivery.
 *
 * @author aSergeev
 *
 */
public interface MqService {

    /**
     * Asynchronously starts verification for specified repository.
     *
     * @param repository specified repository
     */
    void startRepositoryVerification(Repository repository);


    /**
     * Callback for repository verification message processing.
     * 
     * @param message message to process
     */
    void repositoryVerification(Map<String, Object> message);
}
