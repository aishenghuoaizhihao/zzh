package com.example.common.exception;

public class ModifyUserException  extends Exception{

    public ModifyUserException() {
    }

    public ModifyUserException(String message) {
        super(message);
    }

    public ModifyUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModifyUserException(Throwable cause) {
        super(cause);
    }

    public ModifyUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
