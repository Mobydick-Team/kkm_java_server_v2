package com.kkm.kkm_server_v2.domain.jjam.domain.repository;

import com.kkm.kkm_server_v2.domain.jjam.domain.Jjam;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JjamRepository extends JpaRepository<Jjam,Long> {
    List<Jjam> findAllByPost(Post post);
}
