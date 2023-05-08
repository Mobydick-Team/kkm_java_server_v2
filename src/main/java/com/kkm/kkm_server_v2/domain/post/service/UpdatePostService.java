package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.post.facade.PostFacade;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.UpdatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePostService {

    private final PostFacade postFacade;
    private final PostRepository postRepository;

    @Transactional
    public void execute(Long postId, UpdatePostRequest request) {
        Post post = postFacade.findById(postId);

        post.updatePost(request);
    }
}
