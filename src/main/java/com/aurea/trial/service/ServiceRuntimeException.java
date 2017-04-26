package com.aurea.trial.service;

/**
 * Unexpected runtime exception for services.
 * 
 * @author aSergeev
 *
 */
public class ServiceRuntimeException extends RuntimeException {

    public ServiceRuntimeException(String message) {
        super(message);
    }

    public ServiceRuntimeException(String message, Exception ex) {
        super(message, ex);
    }
}
