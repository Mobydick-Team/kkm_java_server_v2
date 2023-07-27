package com.kkm.kkm_server_v2.domain.report.facade;

import com.kkm.kkm_server_v2.domain.report.domain.Report;
import com.kkm.kkm_server_v2.domain.report.domain.repository.ReportRepository;
import com.kkm.kkm_server_v2.domain.report.exception.ReportNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportFacade {
    private final ReportRepository reportRepository;

    public Report findById(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> ReportNotFoundException.EXCEPTION);
    }
}
