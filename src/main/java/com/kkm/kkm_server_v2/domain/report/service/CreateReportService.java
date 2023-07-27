package com.kkm.kkm_server_v2.domain.report.service;

import com.kkm.kkm_server_v2.domain.post.exception.ImageNotFoundException;
import com.kkm.kkm_server_v2.domain.report.domain.Report;
import com.kkm.kkm_server_v2.domain.report.domain.ReportImage;
import com.kkm.kkm_server_v2.domain.report.domain.repository.ReportImageRepository;
import com.kkm.kkm_server_v2.domain.report.domain.repository.ReportRepository;
import com.kkm.kkm_server_v2.domain.report.presantation.dto.request.CreateReportRequest;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateReportService {
    private final UserFacade userFacade;
    private final ReportRepository reportRepository;
    private final ReportImageRepository reportImageRepository;

    @Transactional
    public void execute(CreateReportRequest request) {
        User reporter = userFacade.getCurrentUser(false);
        User target = userFacade.findById(request.getTargetId());
        Report report = request.toEntityWithoutImages(reporter, target);
        if (!request.getUrls().isEmpty()) {
            List<ReportImage> images = request.getUrls().stream().map(url ->
                    reportImageRepository.findByUrl(url)
                            .orElseThrow(() -> ImageNotFoundException.EXCEPTION)
            ).peek(image -> image.setReport(report)).collect(Collectors.toList());
            report.addImage(images);
        }
        reportRepository.save(report);
    }
}
