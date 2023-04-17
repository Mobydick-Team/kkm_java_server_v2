package com.kkm.kkm_server_v2.domain.post.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostStatus {

    ACTIVE("거래 가능"),
    DEACTIVATED("거래 중");

    private final String name;

}
