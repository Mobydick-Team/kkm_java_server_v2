package com.kkm.kkm_server_v2.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {

    ACTIVE("활성화"),
    DEACTIVATED("비활성화");

    private final String name;

}
