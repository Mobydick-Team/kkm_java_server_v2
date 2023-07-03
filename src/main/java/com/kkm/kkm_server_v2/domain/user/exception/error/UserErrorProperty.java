package com.kkm.kkm_server_v2.domain.user.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자가 없습니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다."),
    AUTHORITY_MISMATCH(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    NOT_USER_PAGE(HttpStatus.FORBIDDEN, "마이페이지로 접근해야 합니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
