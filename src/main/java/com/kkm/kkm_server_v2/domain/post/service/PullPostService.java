package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.facade.PostFacade;
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
    private final PostFacade postFacade;
    private final PostRepository postRepository;

    @Transactional
    public void execute(Long postId) {
        User user = userFacade.getCurrentUser(false);
        Post post = postFacade.findById(postId);

        post.validatePermission(user);
        post.validateDate();

        post.pull();
    }

}
