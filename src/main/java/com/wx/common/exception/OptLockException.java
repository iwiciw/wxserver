package com.wx.common.exception;

public class OptLockException extends RuntimeException {
    public OptLockException(String message) {
        super(message);
    }

    public OptLockException(String message, Throwable cause) {
        super(message, cause);
    }
    public OptLockException(Throwable cause) {
        super(cause);
    }
}
