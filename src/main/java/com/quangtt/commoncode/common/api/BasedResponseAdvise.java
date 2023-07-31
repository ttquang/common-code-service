package com.quangtt.commoncode.common.api;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class BasedResponseAdvise implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse
    ) {
        if (methodParameter.getContainingClass().isAnnotationPresent(RestController.class)) {
            if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseBinding.class) == false) {
                if (!(body instanceof BaseResponse)) {
                    BaseResponse wrappedBody = BaseResponse.success(body);
                    return wrappedBody;
                }
            }
        }
        return body;
    }
}
