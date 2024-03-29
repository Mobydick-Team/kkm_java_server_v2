package com.kkm.kkm_server_v2.domain.auth.service;

import com.kkm.kkm_server_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.kkm.kkm_server_v2.domain.auth.presentation.dto.response.TokenResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.enums.UserStatus;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import com.kkm.kkm_server_v2.domain.user.exception.error.UserIsDeactivateException;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findUserByUserId(request.getUserId());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastActivity = user.getModifiedDateTime();
        if (user.getStatus() == UserStatus.DEACTIVATED) {
            if (ChronoUnit.DAYS.between(lastActivity, now) >= 30) {
                user.updateStatus(UserStatus.DELETED);
                userRepository.save(user);
                throw UserNotFoundException.EXCEPTION;
            } else {
                throw UserIsDeactivateException.EXCEPTION;

            }
        } else if (user.getStatus() == UserStatus.DELETED) {
            throw UserNotFoundException.EXCEPTION;
        } else if (user.getStatus().equals(UserStatus.ACTIVE)) {
            return TokenResponse.builder()
                    .accessToken(jwtTokenProvider.generateAccessToken(user.getUserId()))
                    .refreshToken(jwtTokenProvider.generateRefreshToken(user.getUserId()))
                    .name(user.getNickname())
                    .userId(user.getUserId())
                    .build();
        }
        throw UserNotFoundException.EXCEPTION;
    }

}
