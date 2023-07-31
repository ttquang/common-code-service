package com.quangtt.commoncode.common.error;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends CustomException {
    public CategoryNotFoundException() {
        super("Category Not Found", HttpStatus.NOT_FOUND);
    }
}
