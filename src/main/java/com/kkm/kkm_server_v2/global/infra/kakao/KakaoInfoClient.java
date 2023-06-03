package com.kkm.kkm_server_v2.global.infra.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "oauth-info-client", url = "https://kapi.kakao.com")
public interface KakaoInfoClient {

    @PostMapping("/v2/user/me")
    @JsonProperty("id")
    String getProfile(
            @RequestHeader("Authorization") String accessToken
    );

}
