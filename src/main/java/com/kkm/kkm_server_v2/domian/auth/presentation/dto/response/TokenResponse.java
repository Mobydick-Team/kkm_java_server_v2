package com.kkm.kkm_server_v2.domian.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;
    private String refreshToken;
    private String name;
    private String userId;
    private boolean isLogin;
    private Long roleId;
}