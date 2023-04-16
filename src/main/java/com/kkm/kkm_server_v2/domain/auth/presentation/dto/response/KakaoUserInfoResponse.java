package com.kkm.kkm_server_v2.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class KakaoUserInfoResponse {
    private String userId;
}
