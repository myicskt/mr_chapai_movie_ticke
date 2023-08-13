package com.mrchapai.mr_chapai_movie_ticke.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMassage resourceNotFound(ResourceNotFound ex, WebRequest request) {
        ErrorMassage errorMassage = new ErrorMassage(new Date(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));

        return errorMassage;
    }


    @ExceptionHandler(ResourceDataNotMatch.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMassage badRequest(ResourceDataNotMatch rdnm, WebRequest request) {

        ErrorMassage errorMassage = new ErrorMassage(new Date(),
                HttpStatus.BAD_REQUEST.value(),
                rdnm.getMessage(),
                request.getDescription(false));
        return errorMassage;


    }
}


