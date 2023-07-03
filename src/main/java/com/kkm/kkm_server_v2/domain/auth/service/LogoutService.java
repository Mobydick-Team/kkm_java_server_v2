package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.domain.repository.RefreshTokenRepository;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser(false);
        refreshTokenRepository.findByUserId(user.getUserId())
                .ifPresent(refreshTokenRepository::delete);
    }
}
