package com.kkm.kkm_server_v2.domain.post.domain.repository;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
