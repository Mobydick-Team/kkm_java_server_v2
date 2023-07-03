package com.kkm.kkm_server_v2.domain.post.domain.repository;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%', :content, '%') OR p.content LIKE CONCAT('%', :content, '%')")
    Page<Post> findByTitleOrContent(String content, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%', :content, '%') OR p.content LIKE CONCAT('%', :content, '%') and p.category = :category and ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(p.longitude, p.latitude)) <= :distance")
    Page<Post> findByTitleOrContentAndCategoryAndDistance(String content, Pageable pageable, PostCategory category, double longitude, double latitude, int distance);

    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%', :content, '%') OR p.content LIKE CONCAT('%', :content, '%') and ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(p.longitude, p.latitude)) <= :distance")
    Page<Post> findByTitleOrContentAndDistance(String content, Pageable pageable, double longitude, double latitude, int distance);

    @Query("SELECT p FROM Post p WHERE ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(p.longitude, p.latitude)) <= :distance")
    Page<Post> findByDistance(double longitude, double latitude, int distance, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(p.longitude, p.latitude)) <= :distance and p.category = :category")
    Page<Post> findByDistanceAndCategory(double longitude, double latitude, int distance, PostCategory category, Pageable pageable);
}
