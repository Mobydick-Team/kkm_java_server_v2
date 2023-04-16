package com.kkm.kkm_server_v2.domian.user.service;

import com.kkm.kkm_server_v2.domian.user.exception.UserAlreadyExistsException;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CheckUserService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(String nickname) {
        if (userFacade.isUserExistByNickName(nickname)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }
}
