package com.devel.stillcareBackend.exception;

import com.devel.stillcareBackend.exception.exceptionmodels.BadParametersException;
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

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHelper {

        private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

        @ResponseBody
        @ExceptionHandler(HttpClientErrorException.NotFound.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        String handleUnauthorizedException(HttpClientErrorException.NotFound ex) {
                logger.error("Invalid Input Exception: ",ex.getMessage());
                return ex.getMessage();
        }


        @ResponseBody
        @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        String handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
                logger.error("Unauthorized Exception: ",ex.getMessage());
                return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(BadParametersException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        String handleBadParametersException(BadParametersException ex) {
                logger.error("Unauthorized Exception: ",ex.getMessage());
                return ex.getMessage();
        }


        @ResponseBody
        @ExceptionHandler(NotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String employeeNotFoundHandler(NotFoundException ex) {
                logger.error("Exception: ",ex.getMessage());
                return ex.getMessage();
        }


        @ResponseBody
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        String handleException(Exception ex) {
                logger.error("Exception: ",ex.getMessage());
                return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(SQLException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        String handleSQLException(SQLException ex) {
                logger.error("Unauthorized Exception: ",ex.getMessage());
                return ex.getMessage();
        }

}