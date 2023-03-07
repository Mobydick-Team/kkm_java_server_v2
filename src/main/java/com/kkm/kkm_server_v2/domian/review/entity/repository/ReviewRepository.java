package com.kkm.kkm_server_v2.domian.review.entity.repository;

import com.kkm.kkm_server_v2.domian.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
