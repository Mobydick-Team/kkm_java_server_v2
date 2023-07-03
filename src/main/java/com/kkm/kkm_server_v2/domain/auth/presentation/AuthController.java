package com.kkm.kkm_server_v2.domain.auth.presentation;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domain.auth.service.KakaoUserExistService;
import com.kkm.kkm_server_v2.domain.auth.service.LoginService;
import com.kkm.kkm_server_v2.domain.auth.service.LogoutService;
import com.kkm.kkm_server_v2.domain.auth.service.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "인증 서버")
public class AuthController {
    private final RefreshTokenService refreshTokenService;
    private final LoginService loginService;
    private final KakaoUserExistService kakaoUserExistService;
    private final LogoutService logoutService;


    @Operation(summary = "토큰 재발급")
    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        kakaoUserExistService.execute(request.getUserId());
        return loginService.execute(request);
    }

    @Operation(summary = "로그아웃")
    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }
}
