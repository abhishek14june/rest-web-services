package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
