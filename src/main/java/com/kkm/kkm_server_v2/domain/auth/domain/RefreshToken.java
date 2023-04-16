package com.kkm.kkm_server_v2.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refreshToken", timeToLive = 2592000L)
public class RefreshToken {

    @Id
    private String token;

    private String userId;

    @Builder
    public RefreshToken(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }
}