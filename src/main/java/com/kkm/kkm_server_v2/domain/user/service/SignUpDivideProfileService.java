package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpDivideProfileService {
    private final UserRepository userRepository;

    @Transactional
    public void execute(String imgUrl, String userId) {
        User user = userRepository.findUserByUserId(userId);
        if(user == null) {
            throw UserNotFoundException.EXCEPTION;
        }
        user.updateImgUrl(imgUrl);
    }
}
