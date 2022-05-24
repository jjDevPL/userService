package com.jj.wiremock.exception;

public class CommonException extends RuntimeException{
    public CommonException(String not_found) {
        super(not_found);
    }
}
