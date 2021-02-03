package com.devel.stillcareBackend.exception.exceptionmodels;

import com.devel.stillcareBackend.exception.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    public NotFoundException(String msg) {
        super("Could not find" + msg);
        logger.error(msg);

    }
}