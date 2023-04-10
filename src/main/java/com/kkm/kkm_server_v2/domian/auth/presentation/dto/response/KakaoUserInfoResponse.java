package com.kkm.kkm_server_v2.domian.auth.presentation.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class KakaoUserInfoResponse {
    private Long userId;
}
