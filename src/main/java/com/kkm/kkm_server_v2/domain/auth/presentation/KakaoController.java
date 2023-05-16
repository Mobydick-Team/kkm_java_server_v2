package com.kkm.kkm_server_v2.domain.auth.presentation;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.UserInfoResponse;
import com.kkm.kkm_server_v2.domain.auth.service.KakaoAuthService;
import com.kkm.kkm_server_v2.domain.auth.service.KakaoUserExistService;
import com.kkm.kkm_server_v2.domain.auth.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "카카오 서버")
public class KakaoController {


    private final KakaoAuthService kakaoAuthService;

    private final LoginService loginService;
    private final KakaoUserExistService kakaoUserExistService;

    @Operation(summary = "정보 가져오기")
    @GetMapping("/info")
    public UserInfoResponse GetKakaoUserInfo(@RequestParam String code) {
        return kakaoAuthService.getKakaoProfile(code);
    }

    @Operation(summary = "카카오 로그인")
    @PostMapping("/login")
    public TokenResponse KakaoLogin(@RequestBody @Valid LoginRequest request) {
        kakaoUserExistService.execute(request.getUserId());
        return loginService.execute(request);

    }

}
