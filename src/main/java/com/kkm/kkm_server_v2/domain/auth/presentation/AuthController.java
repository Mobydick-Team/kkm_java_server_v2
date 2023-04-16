package com.kkm.kkm_server_v2.domain.auth.presentation;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.kkm.kkm_server_v2.domain.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RefreshTokenService refreshTokenService;

    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }
}
