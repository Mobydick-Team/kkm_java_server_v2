package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpDivideProfileService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(String userId, String imgUrl) {
        User user = userFacade.findUserByUserId(userId);
        user.updateImgUrl(imgUrl);
    }
}
