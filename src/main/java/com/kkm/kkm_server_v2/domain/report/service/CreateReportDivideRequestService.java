package com.kkm.kkm_server_v2.domain.report.service;

import com.kkm.kkm_server_v2.domain.report.domain.repository.ReportRepository;
import com.kkm.kkm_server_v2.domain.report.presantation.dto.request.CreateReportRequest;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateReportDivideRequestService {
    private final UserFacade userFacade;
    private final ReportRepository reportRepository;

    @Transactional
    public void execute(CreateReportRequest request) {
        User reporter = userFacade.getCurrentUser(false);
        User target = userFacade.findById(request.getTargetId());
        reportRepository.save(request.toEntityWithoutImages(reporter, target));

    }
}
