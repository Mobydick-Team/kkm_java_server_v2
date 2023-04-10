package com.kkm.kkm_server_v2.global.error.exception;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {
    HttpStatus getStatus();

    String getMessage();
}
