package com.kkm.kkm_server_v2.domain.post.exception;

import com.kkm.kkm_server_v2.domain.post.exception.error.PostErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class PostAccessWrongException extends KkmException {

    public static final PostAccessWrongException EXCEPTION = new PostAccessWrongException();

    private PostAccessWrongException() {
        super(PostErrorProperty.POST_ACCESS_WRONG);
    }
}
