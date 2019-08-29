package com.example.common.exception;

public class RemoveUserException extends Exception {
    public RemoveUserException() {
    }

    public RemoveUserException(String message) {
        super(message);
    }

    public RemoveUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoveUserException(Throwable cause) {
        super(cause);
    }
}
