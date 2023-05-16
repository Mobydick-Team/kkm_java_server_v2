package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.UserInfoResponse;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfo;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoInfoClient;
import com.kkm.kkm_server_v2.global.infra.kakao.KakaoLoginClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoAuthService {
    private final KakaoInfo kakaoInfo;
    private final KakaoLoginClient kakaoLoginClient;
    private final KakaoInfoClient kakaoInfoClient;
    private final UserRepository userRepository;

    public UserInfoResponse getKakaoProfile(String code) {
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

            KakaoUserInfoResponse kakaoUserInfoResponse = KakaoUserInfoResponse.builder()
                    .id(Long.valueOf(profile))
                    .build();

            if (userRepository.findByUserId(profile).isPresent()) {
                return UserInfoResponse.builder()
                        .kakaoUserInfoResponse(kakaoUserInfoResponse)
                        .isSignedUp(true)
                        .build();
            } else return UserInfoResponse.builder()
                    .kakaoUserInfoResponse(kakaoUserInfoResponse)
                    .isSignedUp(false)
                    .build();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
