package com.kkm.kkm_server_v2.domain.user.exception;

import com.kkm.kkm_server_v2.domain.user.exception.error.UserErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class NotUserPageException extends KkmException {
    public final static NotUserPageException EXCEPTION = new NotUserPageException();

    private NotUserPageException() {
        super(UserErrorProperty.NOT_USER_PAGE);
    }
}
