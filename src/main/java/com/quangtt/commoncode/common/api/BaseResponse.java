package com.quangtt.commoncode.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseResponse implements Serializable {
    private Status status;
    private Object data;
    private Pagination pagination;

    private BaseResponse(Object data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
        this.status = Status.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.name()).build();
    }

    private BaseResponse(Object data) {
        this.data = data;
        this.status = Status.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.name()).build();
    }

    private BaseResponse(Status status) {
        this.status = status;
    }

    public static BaseResponse success(Object data) {
        if (data instanceof Page) {
            Page page = (Page) data;
            return new BaseResponse(
                    page.get().collect(Collectors.toList()),
                    Pagination.builder()
                            .count(page.getNumberOfElements())
                            .limit(page.getTotalPages())
                            .offset(page.getNumber())
                            .total(page.getTotalPages())
                            .build()
            );
        }

        return new BaseResponse(data);
    }

    public static BaseResponse error(Status status) {
        return new BaseResponse(status);
    }

}
