package com.selendemir.finalproject.advice;

import com.selendemir.finalproject.exception.EntityNotFoundException;
import com.selendemir.finalproject.model.exception.ExceptionMessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    Logger logger = Logger.getLogger(getClass().getName());

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessageModel handleEntityNotFoundException(EntityNotFoundException exception){

        ExceptionMessageModel exceptionMessageModel = new ExceptionMessageModel(exception.getMessage());
        logger.log(Level.WARNING,exceptionMessageModel.toString());
        return exceptionMessageModel;
    }
}
