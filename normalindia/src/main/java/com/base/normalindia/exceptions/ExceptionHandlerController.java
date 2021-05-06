package com.base.normalindia.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class ExceptionHandlerController {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ExceptionMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ExceptionMessage message = new ExceptionMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
  }
  

  @ExceptionHandler(UserExistException.class)
  public ResponseEntity<ExceptionMessage> userexistException(UserExistException ex, WebRequest request) {
    ExceptionMessage message = new ExceptionMessage(
        HttpStatus.CONFLICT.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
  }
  

  @ExceptionHandler(EmailExistException.class)
  public ResponseEntity<ExceptionMessage> emailexistException(EmailExistException ex, WebRequest request) {
    ExceptionMessage message = new ExceptionMessage(
        HttpStatus.CONFLICT.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
  }
  

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ExceptionMessage> runtimeException(RuntimeException ex, WebRequest request) {
    ExceptionMessage message = new ExceptionMessage(
        HttpStatus.CONFLICT.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	  ExceptionMessage message = new ExceptionMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return new ResponseEntity<ExceptionMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
