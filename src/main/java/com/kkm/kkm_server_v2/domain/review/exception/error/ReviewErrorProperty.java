package com.kkm.kkm_server_v2.domain.review.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorProperty implements ErrorProperty {
    REVIEW_ACCESS_WRONG(HttpStatus.FORBIDDEN, "리뷰 작성 권한이 없습니다.");
    private final HttpStatus status;
    private final String message;
}
