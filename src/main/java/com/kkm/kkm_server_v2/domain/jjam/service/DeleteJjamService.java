package com.kkm.kkm_server_v2.domain.jjam.service;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.jjam.domain.repository.JjamRepository;
import com.kkm.kkm_server_v2.domain.jjam.exception.JjamAccessWrongException;
import com.kkm.kkm_server_v2.domain.jjam.exception.JjamNotFountException;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteJjamService {
    private final UserFacade userFacade;
    private final JjamRepository jjamRepository;

    @Transactional
    public void execute(Long jjamId) {
        User user = userFacade.getCurrentUser();
        Jjam jjam = jjamRepository.findById(jjamId)
                .orElseThrow(() -> JjamNotFountException.EXCEPTION);
        if (!jjam.getAgent().equals(user))
            throw JjamAccessWrongException.EXCEPTION;
        jjamRepository.delete(jjam);

    }
}
