package com.github.twins.exception;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
public class TwinsMapperException extends RuntimeException {

    public TwinsMapperException(String message) {
        super(message);
    }

    public TwinsMapperException(Throwable cause) {
        super(cause);
    }

    public TwinsMapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
