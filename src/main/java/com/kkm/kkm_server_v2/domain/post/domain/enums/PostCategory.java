package com.kkm.kkm_server_v2.domain.post.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostCategory {

    SHIRT("상의"),
    PANTS("하의"),
    OUTER("아우터"),
    ACCESSORY("액세서리"),
    BAG("가방"),
    SHOES("신발");

    private final String name;
}
