package com.challenge.exceptions;

public class UserNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = -3544451725858932368L;

    public UserNaoEncontradoException() {
    }

    public UserNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNaoEncontradoException(String message) {
        super(message);
    }

    public UserNaoEncontradoException(Throwable cause) {
        super(cause);
    }

}
