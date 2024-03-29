package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.kkm.kkm_server_v2.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserInfoService {
    private final UserFacade userFacade;
    private final AwsS3Service awsS3Service;

    @Transactional
    public void execute(UpdateUserInfoRequest request, String imgUrl) {
        User user = userFacade.getCurrentUser(true);
        awsS3Service.deleteFile(user.getImgUrl());
        user.updateUserInfo(request.getNickname(), imgUrl);
    }
}
