package com.kkm.kkm_server_v2.domain.review.service;

import com.kkm.kkm_server_v2.domain.review.domain.Review;
import com.kkm.kkm_server_v2.domain.review.domain.repository.ReviewRepository;
import com.kkm.kkm_server_v2.domain.review.presentation.dto.response.FindUserReviewListResponse;
import com.kkm.kkm_server_v2.domain.review.presentation.dto.response.FindUserReviewResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindMyReviewService {
    private final UserFacade userFacade;
    private final ReviewRepository reviewRepository;

    public FindUserReviewListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<Review> reviewList = reviewRepository.findAllByOwner(user);
        return FindUserReviewListResponse.builder()
                .list(reviewList.stream().map(FindUserReviewResponse::of).collect(Collectors.toList()))
                .build();
    }
}
