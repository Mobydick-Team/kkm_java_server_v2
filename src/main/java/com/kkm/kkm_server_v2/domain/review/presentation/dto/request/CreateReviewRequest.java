package com.kkm.kkm_server_v2.domain.review.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.review.domain.Review;
import com.kkm.kkm_server_v2.domain.review.domain.enums.RecieveKkomak;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateReviewRequest {
    private String content;
    private RecieveKkomak kkm;
    private Long sourceId;

    public Review toEntity(Trade source) {
        return Review.builder()
                .content(this.content)
                .kkm(this.kkm)
                .source(source)
                .build();
    }
}
