package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoUserExistService {
    private final UserFacade userFacade;

    public boolean execute(String userId) {
        return userFacade.existsUserByUserId(userId);
    }
}
