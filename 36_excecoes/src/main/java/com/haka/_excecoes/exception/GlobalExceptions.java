package com.haka._excecoes.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions{

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processarBadRequest (BadRequestException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
