package com.kkm.kkm_server_v2.domain.jjam.exception;

import com.kkm.kkm_server_v2.domain.jjam.exception.error.JjamErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class JjamNotFountException extends KkmException {
    public static final JjamNotFountException EXCEPTION = new JjamNotFountException();

    private JjamNotFountException() {
        super(JjamErrorProperty.JJAM_NOT_FOUND);
    }
}
