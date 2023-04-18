package com.kkm.kkm_server_v2.domain.jjam.service;

import com.kkm.kkm_server_v2.domain.jjam.domain.repository.JjamRepository;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response.LoadUserJjamsResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoadUserJjamsService {
    private final UserFacade userFacade;
    private final JjamRepository jjamRepository;

    @Transactional
    public LoadUserJjamsResponse execute() {
        User user = userFacade.getCurrentUser();
        return LoadUserJjamsResponse.builder()
                .userjjams(jjamRepository.findAllByAgent(user)).build();
    }
}
