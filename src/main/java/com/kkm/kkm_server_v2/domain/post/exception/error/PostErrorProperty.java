package com.kkm.kkm_server_v2.domain.post.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostErrorProperty implements ErrorProperty {

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),
    POST_ACCESS_WRONG(HttpStatus.FORBIDDEN, "게시글 접근권한이 없습니다."),
    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "이미지를 찾을 수 없습니다."),
    ALREADY_PULL_POST(HttpStatus.FORBIDDEN, "3일에 한 번만 끌어올릴 수 있습니다");

    private final HttpStatus status;
    private final String message;

}
