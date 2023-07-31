package com.quangtt.commoncode.common.api;

import com.quangtt.commoncode.common.error.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        BaseResponse wrappedBody = BaseResponse.error(Status.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build()
        );
        return wrappedBody;
    }

}
