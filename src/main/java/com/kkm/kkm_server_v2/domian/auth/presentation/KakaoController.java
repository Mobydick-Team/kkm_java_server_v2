package com.kkm.kkm_server_v2.domian.auth.presentation;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domian.auth.presentation.dto.response.AccessTokenResponse;
import com.kkm.kkm_server_v2.domian.auth.service.KakaoAuthService;
import com.kkm.kkm_server_v2.domian.auth.service.LoginService;
import com.kkm.kkm_server_v2.domian.auth.service.RefreshTokenService;
import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class KakaoController {


    private final KakaoAuthService kakaoAuthService;

    private final LoginService loginService;
    private final RefreshTokenService refreshTokenService;
    private final UserFacade userFacade;

    @GetMapping( "/user/getKakaoUserInfo")
    public Map<String, Object> GetKakaoUserInfo(@RequestParam String code) throws Exception {
        return kakaoAuthService.getUserInfo(kakaoAuthService.getAccessToken(code));
    }
    @PostMapping( "/user/kakaoLogin")
    public Object KakaoLogin(@RequestBody @Valid LoginRequest request) throws Exception {
        Optional<User> exist = userFacade.isUserExist(request.getUserId()); // user table에 존재하면 존재하는 정보, 존재하지 않으면
        Map<String, Object> userInfo = kakaoAuthService.getUserInfoById(request.getUserId());
        if (exist.isPresent()) { // 회원 가입이 되어있다면 JWT token 보내줘야 함
            return loginService.execute(request);
        } else { // 회원 가입이 안 되어 있다면
            return "guest";
        }
    }

    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }

}
