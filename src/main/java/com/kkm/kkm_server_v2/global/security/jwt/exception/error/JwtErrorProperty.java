package com.kkm.kkm_server_v2.global.security.jwt.exception.error;
import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JwtErrorProperty implements ErrorProperty {

    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),
    ;

    private final int status;
    private final String message;
}