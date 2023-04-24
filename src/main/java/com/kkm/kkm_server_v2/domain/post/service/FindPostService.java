package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
import com.kkm.kkm_server_v2.domain.trade.service.VerifyTradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindPostService {

    private final PostRepository postRepository;
    private final VerifyTradeService verifyTradeService;

    @Transactional(readOnly = true)
    public PostResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        PostStatus status = verifyTradeService.execute(post);
        return PostResponse.of(post, status);
    }

}
