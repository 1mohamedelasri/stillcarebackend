package com.devel.stillcareBackend.exception.exceptionmodels;

import com.devel.stillcareBackend.exception.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotSavedException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    public NotSavedException(String msg) {
        super("Couldn't save " + msg);
        logger.error(msg);

    }
}