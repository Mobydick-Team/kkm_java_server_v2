package com.kkm.kkm_server_v2.global.error.exception;

import lombok.Getter;

@Getter
public class KkmException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String message;

    public KkmException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
