package com.kkm.kkm_server_v2.domain.report.presantation;

import com.kkm.kkm_server_v2.domain.report.presantation.dto.request.CreateReportRequest;
import com.kkm.kkm_server_v2.domain.report.service.CreateReportDivideRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@Tag(name = "신고 서버")
public class ReportController {
    private final CreateReportDivideRequestService createReportDivideRequestService;

    @Operation(summary = "분리된 신고 생성하기")
    @PostMapping("/request")
    public void createReportDivideRequest(@RequestBody CreateReportRequest request) {
        createReportDivideRequestService.execute(request);
    }
}
