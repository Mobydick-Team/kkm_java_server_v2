package com.kkm.kkm_server_v2.global.infra.S3.exception;

import com.kkm.kkm_server_v2.global.error.exception.KkmException;
import com.kkm.kkm_server_v2.global.infra.S3.exception.error.S3ErrorProperty;

public class FileUploadFailedException extends KkmException {
    public final static FileUploadFailedException EXCEPTION = new FileUploadFailedException();

    private FileUploadFailedException() {
        super(S3ErrorProperty.FILE_UPLOAD_FAILED);
    }
}
