package com.devel.stillcareBackend.exception.exceptionmodels;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super("Could not find" + msg);
    }
}