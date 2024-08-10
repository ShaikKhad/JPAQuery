package com.jsp.JPA.Query.mapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
 }
}

