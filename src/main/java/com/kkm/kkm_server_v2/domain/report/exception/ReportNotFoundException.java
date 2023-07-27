package com.kkm.kkm_server_v2.domain.report.exception;

import com.kkm.kkm_server_v2.domain.report.exception.error.ReportErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class ReportNotFoundException extends KkmException {
    public static final ReportNotFoundException EXCEPTION = new ReportNotFoundException();
    public ReportNotFoundException() {
        super(ReportErrorProperty.REPORT_NOT_FOUND);
    }
}
