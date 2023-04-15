package com.kkm.kkm_server_v2.domian.user.service;

import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domian.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domian.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserInfoService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateUserInfoRequest request, String imgUrl) {
        User user = userFacade.getCurrentUser();
        userRepository.save(
                request.toEntity(user, imgUrl)
        );
    }
}
