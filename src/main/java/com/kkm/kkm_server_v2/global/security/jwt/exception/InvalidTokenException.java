package com.kkm.kkm_server_v2.global.security.jwt.exception;

import com.kkm.kkm_server_v2.global.error.exception.KkmException;
import com.kkm.kkm_server_v2.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends KkmException {

    public final static InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(JwtErrorProperty.INVALID_TOKEN);
    }
}