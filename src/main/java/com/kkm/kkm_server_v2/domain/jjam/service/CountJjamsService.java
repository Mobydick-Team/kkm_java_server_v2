package com.kkm.kkm_server_v2.domain.jjam.service;

import com.kkm.kkm_server_v2.domain.jjam.domain.repository.JjamRepository;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response.CountJjamsResponse;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountJjamsService {
    private final PostRepository postRepository;
    private final JjamRepository jjamRepository;

    public CountJjamsResponse execute(Long post_id) {
        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        return CountJjamsResponse.builder()
                .countJjams((jjamRepository.findAllByPost(post)).size()).build();

    }
}
