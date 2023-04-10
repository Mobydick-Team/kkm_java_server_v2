package com.kkm.kkm_server_v2.domian.auth.presentation;

import com.kkm.kkm_server_v2.domian.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.response.AccessTokenResponse;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.kkm.kkm_server_v2.domian.auth.service.KakaoAuthService;
import com.kkm.kkm_server_v2.domian.auth.service.LoginService;
import com.kkm.kkm_server_v2.domian.auth.service.RefreshTokenService;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth/kakao")
@RequiredArgsConstructor
public class KakaoController {


    private final KakaoAuthService kakaoAuthService;

    private final LoginService loginService;
    private final RefreshTokenService refreshTokenService;
    private final UserFacade userFacade;

    @GetMapping("/info")
    public KakaoUserInfoResponse GetKakaoUserInfo(@RequestParam String code) throws Exception {
        return kakaoAuthService.getUserInfo(kakaoAuthService.getAccessToken(code));
    }

    @PostMapping("/login")
    public Object KakaoLogin(@RequestBody @Valid LoginRequest request) throws Exception {
        boolean exist = userFacade.existsUserByUserId(request.getUserId()); // user table에 존재하면 존재하는 정보, 존재하지 않으면
        return loginService.execute(request);

    }

    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }

}
