package com.kkm.kkm_server_v2.global.infra.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "oauth-token-client", url = "https://kauth.kakao.com")
public interface KakaoLoginClient {
    @PostMapping("/oauth/token")
    @JsonProperty("access_token")
    String getAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );
}
