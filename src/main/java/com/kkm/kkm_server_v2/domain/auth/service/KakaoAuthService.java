package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfo;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoLoginClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAuthService {
    private final KakaoInfo kakaoInfo;
    private final KakaoLoginClient kakaoLoginClient;

    public KakaoUserInfoResponse getKakaoProfile(String code) {
        String accessToken = kakaoLoginClient.getAccessToken(
                "authorization_code",
                kakaoInfo.getClientId(),
                kakaoInfo.getRedirectUri(),
                code
        );

        log.info("accessToken : " + accessToken);
        String id = kakaoLoginClient.getProfile("Bearer " + accessToken);
        log.info("userData : " + id);
        return new KakaoUserInfoResponse(Long.valueOf(id));
    }
}
