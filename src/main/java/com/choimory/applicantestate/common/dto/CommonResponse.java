package com.choimory.applicantestate.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class CommonResponse<T> {
    @Builder.Default
    private final int status = 0;
    private final String message;
    private final T data;
}
