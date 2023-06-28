package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserProfileImgService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void execute(String imgUrl) {
        User user = userFacade.getCurrentUser(true);
        user.updateImgUrl(imgUrl);

    }
}
