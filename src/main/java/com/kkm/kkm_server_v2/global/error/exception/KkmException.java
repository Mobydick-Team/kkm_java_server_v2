package com.kkm.kkm_server_v2.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class KkmException extends RuntimeException {

    private final ErrorProperty errorProperty;

}
