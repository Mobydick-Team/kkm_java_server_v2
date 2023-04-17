package com.kkm.kkm_server_v2.domain.post.exception;

import com.kkm.kkm_server_v2.domain.post.exception.error.PostErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class ImageNotFoundException extends KkmException {

    public static final ImageNotFoundException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException() {
        super(PostErrorProperty.IMAGE_NOT_FOUND);
    }
}
