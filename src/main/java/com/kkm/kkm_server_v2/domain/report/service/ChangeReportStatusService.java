package com.kkm.kkm_server_v2.domain.report.service;

import com.kkm.kkm_server_v2.domain.report.domain.Report;
import com.kkm.kkm_server_v2.domain.report.domain.enums.ReportStatus;
import com.kkm.kkm_server_v2.domain.report.facade.ReportFacade;
import com.kkm.kkm_server_v2.domain.report.presantation.dto.request.ChangeReportStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeReportStatusService {
    private final ReportFacade reportFacade;

    @Transactional
    public void execute(ChangeReportStatusRequest request) {
        Report report = reportFacade.findById(request.getReportId());
        report.updateStatus(request.getStatus());
    }
}
