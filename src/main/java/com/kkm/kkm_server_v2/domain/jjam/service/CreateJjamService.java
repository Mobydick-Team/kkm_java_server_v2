package com.kkm.kkm_server_v2.domain.jjam.service;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.jjam.domain.repository.JjamRepository;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.request.CreateJjamRequest;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateJjamService {

    private final UserFacade userFacade;
    private final JjamRepository jjamRepository;
    private final PostRepository postRepository;

    @Transactional
    public void execute(CreateJjamRequest request) {
        User user = userFacade.getCurrentUser(false);
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        Jjam jjam = Jjam.builder()
                .post(post)
                .agent(user)
                .build();
        jjamRepository.save(jjam);
//        user.addJjam(jjam);

    }

}
