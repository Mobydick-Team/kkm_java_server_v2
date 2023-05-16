package com.kkm.kkm_server_v2.global.infra.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
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
