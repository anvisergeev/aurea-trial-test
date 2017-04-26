package com.aurea.trial.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aurea.trial.web.rest.impl.RepositoryResourceImpl;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

/**
 * Jersey configuration.
 *
 * @author aSergeev
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${swagger.version}")
    private String swaggerVersion = "1.0.2";
    @Value("${swagger.scheme}")
    private String swaggerScheme = "http";
    @Value("${swagger.host}")
    private String swaggerHost = "localhost:8080";
    @Value("${swagger.basepath}")
    private String swaggerBasepath = "/";
    @Value("${swagger.resourcePackage}")
    private String swaggerResourcePackage = "com.aurea.trial";


    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }

    /**
     * Registers Jersey endpoints.
     */
    private void registerEndpoints() {
        register(WadlResource.class);
        register(RepositoryResourceImpl.class);
    }


    /**
     * Swagger configuration.
     */
    private void configureSwagger() {
        register(ApiListingResource.class);
        BeanConfig swaggerBeanConfig = new BeanConfig();
        swaggerBeanConfig.setVersion(swaggerVersion);
        swaggerBeanConfig.setSchemes(new String[] {swaggerScheme});
        swaggerBeanConfig.setHost(swaggerHost);
        swaggerBeanConfig.setBasePath(swaggerBasepath);
        swaggerBeanConfig.setResourcePackage(swaggerResourcePackage);
        swaggerBeanConfig.setPrettyPrint(true);
        swaggerBeanConfig.setScan(true);
    }
}

