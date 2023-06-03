package com.kkm.kkm_server_v2.domain.jjam.service;

import com.kkm.kkm_server_v2.domain.jjam.domain.repository.JjamRepository;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response.LoadUserJjamsListResponse;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response.LoadUserJjamsResponse;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.trade.service.VerifyTradeService;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadUserJjamsService {
    private final UserFacade userFacade;
    private final JjamRepository jjamRepository;
    private final VerifyTradeService verifyTradeService;

    @Transactional
    public LoadUserJjamsListResponse execute() {
        User user = userFacade.getCurrentUser(false);
        List<Post> posts = jjamRepository.findAllByAgent(user);
        return LoadUserJjamsListResponse.builder()
                .list(posts.stream().map(item -> {
                    PostStatus status = verifyTradeService.execute(item);
                    return LoadUserJjamsResponse.of(item, status);
                }).collect(Collectors.toList()))
                .build();
    }
}
