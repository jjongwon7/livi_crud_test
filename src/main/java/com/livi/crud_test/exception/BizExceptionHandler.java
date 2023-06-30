package com.livi.crud_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BizExceptionHandler {

    /**********************************************************************************************
     * 수정내용: @@ExceptionHandler Value 삭제
     * 수정이유: Parameter 로 대신하여 Mapped Exception 타입 명시 생략가능
     **********************************************************************************************/
    @ExceptionHandler
    public ResponseEntity<String> invalidMemberRequestException(InvalidMemberRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
