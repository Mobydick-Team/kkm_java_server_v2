package com.kkm.kkm_server_v2.domain.review.exception;

import com.kkm.kkm_server_v2.domain.review.exception.error.ReviewErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class ReviewAccessWrongException extends KkmException {
    public static final ReviewAccessWrongException EXCEPTION = new ReviewAccessWrongException();

    private ReviewAccessWrongException() {
        super(ReviewErrorProperty.REVIEW_ACCESS_WRONG);
    }
}
