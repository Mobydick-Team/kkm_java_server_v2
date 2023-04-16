package com.kkm.kkm_server_v2.domain.user.presentation;

import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.SignUpRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateAddressRequest;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.kkm.kkm_server_v2.domain.user.service.CheckUserService;
import com.kkm.kkm_server_v2.domain.user.service.DivideImageService;
import com.kkm.kkm_server_v2.domain.user.service.SignUpService;
import com.kkm.kkm_server_v2.domain.user.service.UpdateAddressService;
import com.kkm.kkm_server_v2.domain.user.service.UpdateUserInfoService;
import lombok.RequiredArgsConstructor;
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


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CheckUserService checkUserService;
    private final SignUpService signUpService;
    private final UpdateUserInfoService updateUserInfoService;
    private final UpdateAddressService updateAddressService;
    private final DivideImageService divideImageService;

    @PostMapping("/signup")
    public void Signup(@RequestPart(value = "data") @Valid SignUpRequest request, @RequestPart MultipartFile profileImg) {

        signUpService.execute(request, divideImageService.execute(profileImg));
    }

    @GetMapping("/check/{nickname}")
    public void IsNicknameExist(@PathVariable String nickname) {
        checkUserService.execute(nickname);
    }

    @PatchMapping("/update/info")
    public void UpdateUserInfo(@RequestPart(value = "data") @Valid UpdateUserInfoRequest request, @RequestPart MultipartFile profileImg) throws Exception {

        updateUserInfoService.execute(request, divideImageService.execute(profileImg));
    }

    @PutMapping("/update/address")
    public void UpdateAddress(@RequestBody @Valid UpdateAddressRequest request) {
        updateAddressService.execute(request);
    }

}
