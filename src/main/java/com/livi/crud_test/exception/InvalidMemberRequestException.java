package com.livi.crud_test.exception;

public class InvalidMemberRequestException extends RuntimeException {
    public InvalidMemberRequestException() {
        super("존재하지 않는 유저입니다.");
    }
}
