package com.kkm.kkm_server_v2.domain.review.presentation;

import com.kkm.kkm_server_v2.domain.review.presentation.dto.request.CreateReviewRequest;
import com.kkm.kkm_server_v2.domain.review.presentation.dto.response.FindUserReviewListResponse;
import com.kkm.kkm_server_v2.domain.review.service.CreateReviewService;
import com.kkm.kkm_server_v2.domain.review.service.FindMyReviewService;
import com.kkm.kkm_server_v2.domain.review.service.FindUserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final CreateReviewService createReviewService;
    private final FindMyReviewService findMyReviewService;
    private final FindUserReviewService findUserReviewService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @RequestBody CreateReviewRequest request
    ) {
        createReviewService.execute(request);
    }

    @GetMapping("/{id}")
    public FindUserReviewListResponse getUserReview(
            @PathVariable("id") Long id
    ) {
        return findUserReviewService.execute(id);
    }

    @GetMapping("")
    public FindUserReviewListResponse getMyReview() {
        return findMyReviewService.execute();
    }
}
