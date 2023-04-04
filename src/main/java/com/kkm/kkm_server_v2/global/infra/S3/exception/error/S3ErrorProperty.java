package com.kkm.kkm_server_v2.global.infra.S3.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum S3ErrorProperty implements ErrorProperty {

    AUTHORITY_MISMATCH(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,"파일 업로드에 실패했습니다."),
    FORM_MISMATCH(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일입니다.")
    ;

    private final HttpStatus status;
    private final String message;
}
