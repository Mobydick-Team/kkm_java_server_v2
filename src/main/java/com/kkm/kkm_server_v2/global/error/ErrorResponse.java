package com.kkm.kkm_server_v2.global.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;

    public ErrorResponse(ErrorProperty errorProperty) {
        this.status = errorProperty.getStatus();
        this.message = errorProperty.getMessage();
    }
}
