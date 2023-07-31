package com.quangtt.commoncode.common.api;

import com.quangtt.commoncode.common.error.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvice {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse processAllError(CustomException ex) {
        BaseResponse wrappedBody = BaseResponse.error(Status.builder()
                .code(ex.getHttpStatus().value())
                .message(ex.getMessage())
                .build()
        );
        return wrappedBody;
    }

}
