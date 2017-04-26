package com.aurea.trial.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurea.trial.domain.RepositoryState;
import com.aurea.trial.domain.model.Repository;
import com.aurea.trial.repository.RepositoryModelRepository;
import com.aurea.trial.service.MqService;
import com.aurea.trial.service.RepositoryService;

/**
 * Implementation of the repository service interface.
 *
 * @author aSergeev
 *
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    private RepositoryModelRepository repositoryModelRepository;

    @Autowired
    private MqService mqService;

    @Override
    public List<Repository> getRepositories() {
        return repositoryModelRepository.findAll();
    }

    @Transactional
    @Override
    public Repository createRepository(String name, String uri) {
        if (name == null || uri == null) {
            throw new IllegalArgumentException("Name and url parameters must be specified");
        }

        Optional<Repository> foundRepository = repositoryModelRepository.findByName(name);
        if (foundRepository.isPresent()) {
            throw new IllegalArgumentException("Repository with the specified name already exists");
        }

        Repository newRepository = new Repository();
        newRepository.setState(RepositoryState.ADDED);
        newRepository.setName(name);
        newRepository.setUri(uri);
        newRepository.setRegistrationDate(Calendar.getInstance());

        newRepository = repositoryModelRepository.save(newRepository);

        mqService.startRepositoryVerification(newRepository);

        return newRepository;
    }

}
