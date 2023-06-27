package com.livi.crud_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BizExceptionHandler {

    @ExceptionHandler(InvalidMemberRequestException.class)
    public ResponseEntity<String> invalidMemberRequestException(InvalidMemberRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
