package com.kkm.kkm_server_v2.domain.post.exception;

import com.kkm.kkm_server_v2.domain.post.exception.error.PostErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class PostNotFoundException extends KkmException {

    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostErrorProperty.POST_NOT_FOUND);
    }
}
