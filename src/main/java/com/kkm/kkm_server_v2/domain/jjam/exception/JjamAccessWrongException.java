package com.kkm.kkm_server_v2.domain.jjam.exception;

import com.kkm.kkm_server_v2.domain.jjam.exception.error.JjamErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class JjamAccessWrongException extends KkmException {
    public static final JjamAccessWrongException EXCEPTION = new JjamAccessWrongException();

    private JjamAccessWrongException() {
        super(JjamErrorProperty.JJAM_ACCESS_WRONG);
    }
}
