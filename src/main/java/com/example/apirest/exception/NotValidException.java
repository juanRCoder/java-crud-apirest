package com.example.apirest.exception;

public class NotValidException extends RuntimeException {
    private final String errorCode;

    public NotValidException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
