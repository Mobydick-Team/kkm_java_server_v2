package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findUserByUserId(request.getUserId());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getUserId()))
                .refreshToken(jwtTokenProvider.generateRefreshToken(user.getUserId()))
                .build();
    }

}
