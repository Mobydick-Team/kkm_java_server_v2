package com.kkm.kkm_server_v2.domain.user.presentation;

import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.SignUpRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.KakaoUserExistResponse;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.MyPageResponse;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.UserPageResponse;
import com.kkm.kkm_server_v2.domain.user.service.CheckUserService;
import com.kkm.kkm_server_v2.domain.user.service.DivideImageService;
import com.kkm.kkm_server_v2.domain.user.service.MyPageService;
import com.kkm.kkm_server_v2.domain.user.service.SignUpDivideProfileService;
import com.kkm.kkm_server_v2.domain.user.service.SignUpDivideRequestService;
import com.kkm.kkm_server_v2.domain.user.service.SignUpService;
import com.kkm.kkm_server_v2.domain.user.service.UpdateUserInfoService;
import com.kkm.kkm_server_v2.domain.user.service.UpdateUserProfileImgService;
import com.kkm.kkm_server_v2.domain.user.service.UserPageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private final DivideImageService divideImageService;
    private final MyPageService myPageService;
    private final SignUpDivideRequestService signUpDivideRequestService;
    private final UpdateUserProfileImgService updateUserProfileImgService;
    private final SignUpDivideProfileService signUpDivideProfileService;
    private final UserPageService userPageService;


    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void Signup(@RequestPart(value = "data") @Valid SignUpRequest request, @RequestPart List<MultipartFile> profileImg) {
        signUpService.execute(request, divideImageService.execute(profileImg));
    }

    @Operation(summary = "분리된 회원 가입")
    @PostMapping("/signup/request")
    public void SignupRequest(@RequestBody @Valid SignUpRequest request) {
        signUpDivideRequestService.execute(request);
    }

    @Operation(summary = "분리된 회원 가입")
    @PostMapping("/signup/image/{userId}")
    public void SignupProfile(@RequestPart List<MultipartFile> profileImg, @PathVariable String userId) {
        signUpDivideProfileService.execute(divideImageService.execute(profileImg), userId);
    }

    @Operation(summary = "이미지 업데이트")
    @PostMapping("/update/image")
    public void SignupImage(@RequestPart List<MultipartFile> profileImg) {
        updateUserProfileImgService.execute(divideImageService.execute(profileImg));
    }

    @Operation(summary = "닉네임 중복 확인")
    @GetMapping("/check/{nickname}")
    public KakaoUserExistResponse IsNicknameExist(@PathVariable String nickname) {
        return checkUserService.execute(nickname);
    }

    @Operation(summary = "유저 정보 업데이트")
    @PatchMapping("/update/info")
    public void UpdateUserInfo(@RequestPart(value = "data") @Valid UpdateUserInfoRequest request, @RequestPart List<MultipartFile> profileImg) throws Exception {
        updateUserInfoService.execute(request, divideImageService.execute(profileImg));
    }

    @Operation(summary = "마이페이지")
    @GetMapping("/mypage")
    public MyPageResponse GetMyPage() {
        return myPageService.execute();
    }

    @Operation(summary = "다른 사용자 페이지")
    @GetMapping("/page/{id}")
    public UserPageResponse GetUserPage(@PathVariable Long id) {
        return userPageService.execute(id);
    }
}
