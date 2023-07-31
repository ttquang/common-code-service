package com.quangtt.commoncode.common.error;

import org.springframework.http.HttpStatus;

public class InternalServerError extends CustomException {
    public InternalServerError(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
