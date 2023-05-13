package com.kkm.kkm_server_v2.domain.user.presentation;

import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.SignUpRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateAddressRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.MyPageResponse;
import com.kkm.kkm_server_v2.domain.user.service.CheckUserService;
import com.kkm.kkm_server_v2.domain.user.service.DivideImageService;
import com.kkm.kkm_server_v2.domain.user.service.MyPageService;
import com.kkm.kkm_server_v2.domain.user.service.SignUpService;
import com.kkm.kkm_server_v2.domain.user.service.UpdateAddressService;
import com.kkm.kkm_server_v2.domain.user.service.UpdateUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "유저 서버")
public class UserController {

    private final CheckUserService checkUserService;
    private final SignUpService signUpService;
    private final UpdateUserInfoService updateUserInfoService;
    private final UpdateAddressService updateAddressService;
    private final DivideImageService divideImageService;
    private final MyPageService myPageService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void Signup(@RequestPart(value = "data") @Valid SignUpRequest request, @RequestPart List<MultipartFile> profileImg) {
        signUpService.execute(request, divideImageService.execute(profileImg));
    }

    @Operation(summary = "닉네임 중복 확인")
    @GetMapping("/check/{nickname}")
    public void IsNicknameExist(@PathVariable String nickname) {
        checkUserService.execute(nickname);
    }

    @Operation(summary = "유저 정보 업데이트")
    @PatchMapping("/update/info")
    public void UpdateUserInfo(@RequestPart(value = "data") @Valid UpdateUserInfoRequest request, @RequestPart MultipartFile profileImg) throws Exception {

        updateUserInfoService.execute(request, divideImageService.execute(profileImg));
    }

    @Operation(summary = "주소 업데이트")
    @PutMapping("/update/address")
    public void UpdateAddress(@RequestBody @Valid UpdateAddressRequest request) {
        updateAddressService.execute(request);
    }

    @Operation(summary = "마이페이지")
    @GetMapping("/mypage")
    public MyPageResponse GetMyPage() {
        return myPageService.execute();
    }

}
