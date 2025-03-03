package com.choimory.applicantestate.common.exception;

import com.choimory.applicantestate.common.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionAdvice {
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<String> exception(Exception e) {
        return CommonResponse.<String>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .data(e.getMessage())
                .build();
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<String> runtimeException(Exception e) {
        return CommonResponse.<String>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .data(e.getMessage())
                .build();
    }

    @ExceptionHandler({CommonException.class})
    public ResponseEntity<CommonResponse<String>> commonException(CommonException e) {
        return new ResponseEntity<>(CommonResponse.<String>builder()
                .status(e.getStatus())
                .message(e.getMessage())
                .build(), e.getHttpStatus());
    }
}
