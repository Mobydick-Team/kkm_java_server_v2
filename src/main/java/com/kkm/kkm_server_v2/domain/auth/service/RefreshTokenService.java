package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.domain.RefreshToken;
import com.kkm.kkm_server_v2.domain.auth.domain.repository.RefreshTokenRepository;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.kkm.kkm_server_v2.global.security.jwt.JwtTokenProvider;
import com.kkm.kkm_server_v2.global.security.jwt.exception.ExpiredTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return AccessTokenResponse.builder().accessToken(jwtTokenProvider.generateAccessToken(refreshToken.getUserId())).build();
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token).orElseThrow(() -> ExpiredTokenException.EXCEPTION);
    }
}

