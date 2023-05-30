package com.kkm.kkm_server_v2.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoUserExistResponse {
    private boolean isExist;
}
