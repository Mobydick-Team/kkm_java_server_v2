package com.kkm.kkm_server_v2.domain.jjam.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum JjamErrorProperty implements ErrorProperty {
    JJAM_NOT_FOUND(HttpStatus.NOT_FOUND, "쨈을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
