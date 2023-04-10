package com.kkm.kkm_server_v2.domian.auth.service;

import com.kkm.kkm_server_v2.domian.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
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
                .isLogin(!(user.getNickname() == null || user.getNickname().equals("")))
                .build();
    }

}
