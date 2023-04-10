package com.kkm.kkm_server_v2.domian.user.presentation;

import com.kkm.kkm_server_v2.domian.user.presentation.dto.request.SignUpRequest;
import com.kkm.kkm_server_v2.domian.user.presentation.dto.request.UpdateAddressRequest;
import com.kkm.kkm_server_v2.domian.user.presentation.dto.request.UpdateUserInfoRequest;
import com.kkm.kkm_server_v2.domian.user.service.CheckUserService;
import com.kkm.kkm_server_v2.domian.user.service.SignUpService;
import com.kkm.kkm_server_v2.domian.user.service.UpdateAddressService;
import com.kkm.kkm_server_v2.domian.user.service.UpdateUserInfoService;
import com.kkm.kkm_server_v2.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {

    private final CheckUserService checkUserService;
    private final AwsS3Service awsS3Service;
    private final SignUpService signUpService;
    private final UpdateUserInfoService updateUserInfoService;
    private final UpdateAddressService updateAddressService;

    @PostMapping("/signup")
    public void Signup(@RequestPart(value = "data") @Valid SignUpRequest request, @RequestPart MultipartFile profileImg) {
        List<MultipartFile> list = null;
        list.add(profileImg);
        List<String> imgList = awsS3Service.uploadFile(list);
        signUpService.execute(request, imgList.get(0));
    }

    @GetMapping("/check/{nickname}")
    public boolean IsNicknameExist(@PathVariable String nickname) {
        return checkUserService.execute(nickname);
    }

    @PutMapping("/update/info")
    public void UpdateUserInfo(@RequestPart(value = "data") @Valid UpdateUserInfoRequest request, @RequestPart MultipartFile profileImg) throws Exception {
        List<MultipartFile> list = null;
        list.add(profileImg);
        List<String> imgList = awsS3Service.uploadFile(list);
        updateUserInfoService.execute(request, imgList.get(0));
    }

    @PutMapping("/update/address")
    public void UpdateAddress(@RequestBody @Valid UpdateAddressRequest request){
        updateAddressService.execute(request);
    }

}
