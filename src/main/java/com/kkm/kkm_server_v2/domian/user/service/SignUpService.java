package com.kkm.kkm_server_v2.domian.user.service;

import com.kkm.kkm_server_v2.domian.user.domain.Role;
import com.kkm.kkm_server_v2.domian.user.domain.User;
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
                User.builder()
                        .userId(request.getUserId())
                        .imgUrl(imgUrl)
                        .address(request.getAddress())
                        .longitude(request.getLongitude())
                        .latitude(request.getLatitude())
                        .nickname(request.getNickname())
                        .role(Role.USER)
                        .build()
        );
    }
}
