package com.kkm.kkm_server_v2.domain.jjam.service;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.jjam.domain.repository.JjamRepository;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IsJjammedService {
    private final JjamRepository jjamRepository;

    public boolean execute(User user, Post post) {
        Jjam jjam = jjamRepository.findByAgentAndPost(user, post);
        return jjam != null;
    }
}
