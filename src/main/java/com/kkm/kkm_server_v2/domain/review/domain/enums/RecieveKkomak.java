package com.kkm.kkm_server_v2.domain.review.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecieveKkomak {
    HAVING_KKOMAK("있꼬막"),
    HAVING_NO_KKOMAK("없꼬막");
    private final String name;
}
