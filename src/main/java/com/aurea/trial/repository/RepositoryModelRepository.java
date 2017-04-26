package com.aurea.trial.repository;

import com.aurea.trial.domain.model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for GitHub repository models.
 *
 * @author aSergeev
 *
 */
public interface RepositoryModelRepository extends JpaRepository<Repository, Long> {

    /**
     * Searches for repository with the specified name
     *
     * @param name
     *            name of the repository
     * @return found repository
     */
    Optional<Repository> findByName(String name);

}
