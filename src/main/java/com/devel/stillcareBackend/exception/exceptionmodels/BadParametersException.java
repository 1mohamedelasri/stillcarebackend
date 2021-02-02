package com.devel.stillcareBackend.exception.exceptionmodels;

public class BadParametersException extends RuntimeException {

    public BadParametersException(String msg) {
        super("Received bad or null parameters : " + msg);
    }
}