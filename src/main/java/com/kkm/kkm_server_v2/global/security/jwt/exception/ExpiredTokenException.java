package com.kkm.kkm_server_v2.global.security.jwt.exception;


import com.kkm.kkm_server_v2.global.error.exception.KkmException;
import com.kkm.kkm_server_v2.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends KkmException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}