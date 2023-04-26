package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.AlreadyPullPostException;
import com.kkm.kkm_server_v2.domain.post.exception.PostAccessWrongException;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PullPostService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;

    @Transactional
    public void execute(Long postId) {
        User author = userFacade.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if(post.getAuthor().equals(author))
            throw PostAccessWrongException.EXCEPTION;

        if(LocalDateTime.now().isAfter(post.getPullDate().plusDays(3)))
            throw AlreadyPullPostException.EXCEPTION;

        post.updatePullDate();
        postRepository.save(post);
    }

}
