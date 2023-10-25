package br.com.enterprise.costcontroller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMapperAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorBody handleNotFoundException(NotFoundException e){
        return new ErrorBody(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(InvalidEntryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorBody handleInvalidEntryException(InvalidEntryException e){
        return new ErrorBody(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}