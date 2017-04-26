package com.aurea.trial.web.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Interface for REST service for GitHub repositories management.
 *
 * @author aSergeev
 *
 */
@Path("/repository")
@Api("/repository")
@Produces(MediaType.APPLICATION_JSON)
public interface RepositoryResource {

    @GET
    @Path("/repositories")
    @ApiOperation(value = "Find all repositories", notes = "Returns a list of all repositories")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server error")})
    public Response getRepositories();

    @POST
    @Path("/repository")
    @ApiOperation(value = "Add a new repository")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    public Response createRepository(
            @ApiParam(value = "Name of the repository") @FormParam("name") String name,
            @ApiParam(value = "URL of the repository") @FormParam("uri") String uri);
}
