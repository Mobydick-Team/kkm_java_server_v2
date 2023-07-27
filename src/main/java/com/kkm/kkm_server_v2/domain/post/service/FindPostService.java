package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.jjam.service.IsJjammedService;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostDetailResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindPostService {

    private final PostRepository postRepository;
    private final IsJjammedService isJjammedService;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public PostDetailResponse execute(Long postId) {
        User user = userFacade.getCurrentUser(false);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        return PostDetailResponse.of(post, isJjammedService.execute(user, post));
    }

}
