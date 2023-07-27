package com.kkm.kkm_server_v2.domain.report.presantation.dto.request;

import com.kkm.kkm_server_v2.domain.report.domain.enums.ReportStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeReportStatusRequest {

    private Long reportId;
    private ReportStatus status;
}
