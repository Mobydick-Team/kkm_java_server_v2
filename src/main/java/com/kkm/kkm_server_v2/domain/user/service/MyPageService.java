package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.jjam.service.IsJjammedService;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.MyPageResponse;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final IsJjammedService isJjammedService;

    @Transactional
    public MyPageResponse execute() {
        User user = userRepository.fetchFindByUserId(userFacade.getCurrentUser().getUserId());

        return MyPageResponse.of(user, new PostListResponse((
                user.getPostList().stream().map(post ->
                        PostResponse.of(post, isJjammedService.execute(user, post))
                ).collect(Collectors.toList())
        )), new PostListResponse((
                user.getJjamPostList().stream().map(post ->
                        PostResponse.of(post, true)
                ).collect(Collectors.toList()))));
        //        ))

    }
}
