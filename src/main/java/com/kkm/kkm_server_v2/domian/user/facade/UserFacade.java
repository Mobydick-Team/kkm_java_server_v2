package com.kkm.kkm_server_v2.domian.user.facade;

import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domian.user.exception.UserNotFoundException;
import com.kkm.kkm_server_v2.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    @Transactional
    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }

    @Transactional
    public User findUserByUserId(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional
    public boolean isUserExistByNickName(String nickname) {
        return userRepository.existsUserByNickname(nickname);
    }

    @Transactional(readOnly = true)
    public void existsUserByUserId(String userId) {
        if (!userRepository.existsUserByUserId(userId)) throw UserNotFoundException.EXCEPTION;
    }
}
