package com.kkm.kkm_server_v2.domian.user.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    USER_ALREADY_EXISTS(422, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(404, "사용자가 없습니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 틀렸습니다."),
    AUTHORITY_MISMATCH(403, "권한이 없습니다."),
            ;

    private final int status;
    private final String message;
}
