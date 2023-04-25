package com.kkm.kkm_server_v2.domain.review.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.review.domain.Review;
import com.kkm.kkm_server_v2.domain.review.domain.enums.RecieveKkomak;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FindUserReviewResponse {
    private String content;
    private RecieveKkomak kkm;
    private String thumbnailUrl;
    private String userImgUrl;
    private String userName;
    private String title;

    public static FindUserReviewResponse of(Review review) {
        return FindUserReviewResponse.builder()
                .content(review.getContent())
                .kkm(review.getKkm())
                .thumbnailUrl(review.getSource().getPostId().getImageList().get(0).getUrl())
                .title(review.getSource().getPostId().getTitle())
                .userImgUrl(review.getOwner().getImgUrl())
                .userName(review.getOwner().getUsername())
                .build();
    }
}
