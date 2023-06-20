package com.kkm.kkm_server_v2.domain.location.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum LocationErrorProperty implements ErrorProperty {
    LOCATION_COUNT_EXCEED(HttpStatus.BAD_REQUEST, "위치는 3개까지 등록할 수 있습니다."),
    LOCATION_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 등록된 위치 정보입니다."),
    LOCATION_NOT_FOUND(HttpStatus.NOT_FOUND, "위치 정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
