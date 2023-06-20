package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.location.domain.repository.LocationRepository;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserAlreadyExistsException;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public void execute(SignUpRequest request, String imgUrl) {
        userRepository.findByUserId(request.getUserId())
                .ifPresent(m -> {
                    throw UserAlreadyExistsException.EXCEPTION;
                });

        User user = userRepository.save(request.toEntityUser(imgUrl));
        locationRepository.save(request.toEntityLocation(user, true));
    }
}
