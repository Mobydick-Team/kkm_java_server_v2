package com.kkm.kkm_server_v2.global.infra.S3.exception;

import com.kkm.kkm_server_v2.global.error.exception.KkmException;
import com.kkm.kkm_server_v2.global.infra.S3.exception.error.S3ErrorProperty;

public class ResponseStatusException extends KkmException {
    public final static ResponseStatusException EXCEPTION = new ResponseStatusException();
    private ResponseStatusException() {
        super(S3ErrorProperty.FORM_MISMATCH);
    }

}
