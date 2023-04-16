package com.kkm.kkm_server_v2.domain.auth.presentation;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domain.auth.service.KakaoAuthService;
import com.kkm.kkm_server_v2.domain.auth.service.KakaoUserExistService;
import com.kkm.kkm_server_v2.domain.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/kakao")
@RequiredArgsConstructor
public class KakaoController {


    private final KakaoAuthService kakaoAuthService;

    private final LoginService loginService;
    private final KakaoUserExistService kakaoUserExistService;

    @GetMapping("/info")
    public KakaoUserInfoResponse GetKakaoUserInfo(@RequestParam String code) {
        return kakaoAuthService.getKakaoProfile(code);
    }

    @PostMapping("/login")
    public TokenResponse KakaoLogin(@RequestBody @Valid LoginRequest request) {
        kakaoUserExistService.execute(request.getUserId());
        return loginService.execute(request);

    }

}
