package com.example.common.exception;

/**
 * Author：zzh
 * Date：2019
 * Description：<描述>
 */
public class LoginErrorException extends Exception {
    public LoginErrorException() {
        super();
    }

    public LoginErrorException(String message) {
        super(message);
    }

    public LoginErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginErrorException(Throwable cause) {
        super(cause);
    }
}
