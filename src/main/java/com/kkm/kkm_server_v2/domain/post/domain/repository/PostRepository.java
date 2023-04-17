package com.kkm.kkm_server_v2.domain.post.domain.repository;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByCategory(PostCategory category, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%', :content, '%') OR p.content LIKE CONCAT('%', :content, '%')")
    Page<Post> findByTitleOrContent(String content, Pageable pageable);

}
