package com.kkm.kkm_server_v2.domain.post.exception;

import com.kkm.kkm_server_v2.domain.post.exception.error.PostErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class AlreadyPullPostException extends KkmException {

    public static final AlreadyPullPostException EXCEPTION = new AlreadyPullPostException();

    private AlreadyPullPostException() {
        super(PostErrorProperty.ALREADY_PULL_POST);
    }
}
