package com.kkm.kkm_server_v2.domain.review.domain.repository;

import com.kkm.kkm_server_v2.domain.review.domain.Review;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByOwner(User user);
}
