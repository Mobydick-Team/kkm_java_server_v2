package com.kkm.kkm_server_v2.domian.post.entity.repository;

import com.kkm.kkm_server_v2.domian.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
