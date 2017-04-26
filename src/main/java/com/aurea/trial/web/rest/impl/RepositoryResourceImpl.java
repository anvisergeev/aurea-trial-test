package com.aurea.trial.web.rest.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurea.trial.domain.model.Repository;
import com.aurea.trial.service.RepositoryService;
import com.aurea.trial.web.rest.RepositoryResource;

/**
 * Implementation of REST service for GitHub repositories management.
 *
 * @author aSergeev
 *
 */
@Component
public class RepositoryResourceImpl implements RepositoryResource {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public Response getRepositories() {
        List<Repository> repositories = repositoryService.getRepositories();
        return Response.ok().entity(repositories).build();
    }

    @Override
    public Response createRepository(String name, String uri) {
        Repository respository = repositoryService.createRepository(name, uri);
        return Response.ok().entity(respository).build();
    }

}
