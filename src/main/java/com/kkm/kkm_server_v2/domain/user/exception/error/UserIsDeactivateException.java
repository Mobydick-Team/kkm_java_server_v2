package com.kkm.kkm_server_v2.domain.user.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class UserIsDeactivateException extends KkmException {
    public final static UserIsDeactivateException EXCEPTION = new UserIsDeactivateException();

    private UserIsDeactivateException() {
        super(UserErrorProperty.USER_IS_DEACTIVATED);
    }
}
