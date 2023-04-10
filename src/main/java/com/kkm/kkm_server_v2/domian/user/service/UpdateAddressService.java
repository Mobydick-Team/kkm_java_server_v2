package com.kkm.kkm_server_v2.domian.user.service;

import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domian.user.presentation.dto.request.UpdateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAddressService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateAddressRequest request) {
        User user = userFacade.getCurrentUser(request.getId());
        userRepository.save(
                User.builder()
                        .userId(user.getUserId())
                        .imgUrl(user.getImgUrl())
                        .address(request.getAddress())
                        .longitude(request.getLongitude())
                        .latitude(request.getLatitude())
                        .nickname(user.getNickname())
                        .role(user.getRole())
                        .build()
        );
    }
}
