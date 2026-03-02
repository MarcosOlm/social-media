package com.example.social_media.controllers.exceptions;

import com.example.social_media.services.exceptions.ResourceAlreadyExist;
import com.example.social_media.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Resource not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<StandardError> resourceAlreadyExist(ResourceAlreadyExist e, HttpServletRequest request) {
        StandardError err = new StandardError(Instant.now(), HttpStatus.CONFLICT.value(), "Resource already exist", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
}
