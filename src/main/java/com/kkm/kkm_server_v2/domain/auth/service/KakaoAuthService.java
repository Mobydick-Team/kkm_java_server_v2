package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfo;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfoClient;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoLoginClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAuthService {
    private final KakaoInfo kakaoInfo;
    private final KakaoLoginClient kakaoLoginClient;
    private final KakaoInfoClient kakaoInfoClient;

    public KakaoUserInfoResponse getKakaoProfile(String code) {
        String response = kakaoLoginClient.getAccessToken(
                "authorization_code",
                kakaoInfo.getClientId(),
                kakaoInfo.getRedirectUri(),
                code
        );

        try {
            String accessToken = new JSONObject(response)
                    .get("access_token")
                    .toString();

            String profile = new JSONObject(kakaoInfoClient.getProfile("Bearer " + accessToken))
                    .get("id")
                    .toString();
            return new KakaoUserInfoResponse(Long.valueOf(profile));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
