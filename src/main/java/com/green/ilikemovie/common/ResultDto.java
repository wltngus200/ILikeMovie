package com.green.ilikemovie.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ResultDto<T> {
    private HttpStatus status;
    private String resultMsg;
    private T resultData;
}
