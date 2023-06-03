package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.user.exception.UserAlreadyExistsException;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.KakaoUserExistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CheckUserService {
    private final UserFacade userFacade;

    @Transactional
    public KakaoUserExistResponse execute(String nickname) {
        if (userFacade.isUserExistByNickName(nickname))
            return KakaoUserExistResponse.builder().isExist(true).build();
        else
            return KakaoUserExistResponse.builder().isExist(false).build();
    }
}
