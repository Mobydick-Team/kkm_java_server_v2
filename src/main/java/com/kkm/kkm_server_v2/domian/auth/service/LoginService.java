package com.kkm.kkm_server_v2.domian.auth.service;

import com.kkm.kkm_server_v2.domian.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kkm.kkm_server_v2.global.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findUserByUserId(request.getUserId());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserId()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getUserId()))
                .isLogin(!(user.getNickname() == null || user.getNickname().equals("")))
                .build();
    }

}
