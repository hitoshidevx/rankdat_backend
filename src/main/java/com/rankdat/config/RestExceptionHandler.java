package com.rankdat.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.rankdat.models.RestValidationError;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("erro de argumento inválido");

        List<RestValidationError> errors = new ArrayList<>();

        e.getFieldErrors().forEach(g -> errors.add(new RestValidationError(400, g.getField(), g.getDefaultMessage())));
        
        return ResponseEntity.badRequest().body(errors);
    }
    
}
