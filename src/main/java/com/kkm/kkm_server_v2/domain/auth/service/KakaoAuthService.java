package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfo;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfoClient;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoLoginClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoAuthService {
    private final KakaoInfo kakaoInfo;
    private final KakaoLoginClient kakaoLoginClient;
    private final KakaoInfoClient kakaoInfoClient;

    public KakaoUserInfoResponse getKakaoProfile(String code) {
        String accessToken = kakaoLoginClient.getAccessToken(
                "authorization_code",
                kakaoInfo.getClientId(),
                kakaoInfo.getRedirectUri(),
                code
        );

        return new KakaoUserInfoResponse(kakaoInfoClient.getProfile("Bearer " + accessToken));
    }
}
