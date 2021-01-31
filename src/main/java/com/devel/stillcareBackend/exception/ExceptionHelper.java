package com.devel.stillcareBackend.exception;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.*;

@ControllerAdvice
public class ExceptionHelper {

        private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

        @ExceptionHandler(value = { HttpClientErrorException.NotFound.class })
        public ResponseEntity<Object> handleInvalidInputException(HttpClientErrorException.NotFound ex) {
                logger.error("Invalid Input Exception: ",ex.getMessage());
                return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(value = { HttpClientErrorException.Unauthorized.class })
        public ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
                logger.error("Unauthorized Exception: ",ex.getMessage());
                return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = { Exception.class })
        public ResponseEntity<Object> handleException(Exception ex) {

                logger.error("Exception: ",ex.getMessage());
                return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ResponseBody
        @ExceptionHandler(NotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String employeeNotFoundHandler(NotFoundException ex) {
                return ex.getMessage();
        }
}