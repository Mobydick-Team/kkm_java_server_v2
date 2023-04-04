package com.kkm.kkm_server_v2.domian.user.exception;

import com.kkm.kkm_server_v2.domian.user.exception.error.UserErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class UserAlreadyExistsException extends KkmException {
    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();
    private UserAlreadyExistsException() {
        super(UserErrorProperty.USER_ALREADY_EXISTS);
    }
}
