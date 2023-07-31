package com.quangtt.commoncode.common.error;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    HttpStatus httpStatus;

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
