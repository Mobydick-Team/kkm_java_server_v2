package com.kkm.kkm_server_v2.domain.user.exception;

import com.kkm.kkm_server_v2.domain.user.exception.error.UserErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class UserNotFoundException extends KkmException {
    public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
