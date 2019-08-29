package com.example.common.exception;

public class InserUserException extends Exception {
    public InserUserException() {
    }

    public InserUserException(String message) {
        super(message);
    }

    public InserUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InserUserException(Throwable cause) {
        super(cause);
    }
}
