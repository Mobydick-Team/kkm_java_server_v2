package com.kkm.kkm_server_v2.domain.review.domain.repository;

import com.kkm.kkm_server_v2.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
