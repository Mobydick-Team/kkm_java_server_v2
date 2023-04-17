package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindPostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponse execute(Long postId) {
        return PostResponse.of(postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION));
    }

}
