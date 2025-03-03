package com.choimory.applicantestate.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final int status;
    private final String message;

    @Builder
    public CommonException(HttpStatus httpStatus, int status, String message) {
        this.httpStatus = httpStatus;
        this.status = status;
        this.message = message;
    }
}
