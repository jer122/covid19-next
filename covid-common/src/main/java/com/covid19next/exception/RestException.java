package com.covid19next.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
public class RestException extends RuntimeException {


    private Short reasonCode;
    private String returnAuthMsg;
    private String errMsg;

    public RestException(String errMsg) {
        super(errMsg);
        log.info("RestException -> {}", errMsg);
        this.errMsg = errMsg;
    }
}
