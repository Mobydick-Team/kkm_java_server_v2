package com.kkm.kkm_server_v2.domain.auth.presentation;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.UserInfoResponse;
import com.kkm.kkm_server_v2.domain.auth.service.KakaoAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/kakao")
@RequiredArgsConstructor
@Tag(name = "카카오 서버")
public class KakaoController {
    private final KakaoAuthService kakaoAuthService;

    @Operation(summary = "정보 가져오기")
    @GetMapping("/info")
    public UserInfoResponse GetKakaoUserInfo(@RequestParam String code) {
        return kakaoAuthService.getKakaoProfile(code);
    }

}
