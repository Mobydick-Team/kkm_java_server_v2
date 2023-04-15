package com.kkm.kkm_server_v2.domian.user.service;

import com.kkm.kkm_server_v2.domian.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domian.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;

    @Transactional
    public void execute(SignUpRequest request, String imgUrl) {
        userRepository.save(
                request.toEntity(imgUrl)
        );
    }
}
