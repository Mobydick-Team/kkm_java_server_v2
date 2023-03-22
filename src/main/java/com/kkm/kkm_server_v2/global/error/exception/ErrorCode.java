package com.kkm.kkm_server_v2.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "서버에서 에러가 발생했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 틀렸습니다."),
    USER_ALREADY_EXISTS(422, "유저가 이미 존재합니다.");

    private final int status;
    private final String message;
}
