package com.kkm.kkm_server_v2.domain.jjam.domain.repository;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JjamRepository extends JpaRepository<Jjam, Long> {
    List<Jjam> findAllByPost(Post post);

    @Query("SELECT j.post FROM Jjam j WHERE j.agent = :user")
    List<Post> findAllByAgent(User user);
    Jjam findByAgentAndPost(User user, Post post);
}
