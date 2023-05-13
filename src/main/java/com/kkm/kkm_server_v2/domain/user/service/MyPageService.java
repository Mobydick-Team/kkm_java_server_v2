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

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final IsJjammedService isJjammedService;

    public MyPageResponse execute() {
        User user = userRepository.findByUserId(userFacade.getCurrentUser().getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return MyPageResponse.of(user, PostListResponse.builder()
                .postResponseList(
                        user.getPostList().stream().map(post ->
                                PostResponse.of(post, isJjammedService.execute(user, post))
                        ).collect(Collectors.toList())
                ).build(), PostListResponse.builder()
                .postResponseList(
                        user.getJjamPostList().stream().map(post ->
                                PostResponse.of(post, true)
                        ).collect(Collectors.toList())
                ).build());

    }
}
