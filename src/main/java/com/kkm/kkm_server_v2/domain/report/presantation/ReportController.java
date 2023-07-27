package com.kkm.kkm_server_v2.domain.report.presantation;

import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.ImageResponse;
import com.kkm.kkm_server_v2.domain.report.presantation.dto.request.ChangeReportStatusRequest;
import com.kkm.kkm_server_v2.domain.report.presantation.dto.request.CreateReportRequest;
import com.kkm.kkm_server_v2.domain.report.service.ChangeReportStatusService;
import com.kkm.kkm_server_v2.domain.report.service.CreateReportService;
import com.kkm.kkm_server_v2.domain.report.service.UploadImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@Tag(name = "신고 서버")
public class ReportController {
    private final CreateReportService createReportService;
    private final UploadImageService uploadImageService;
    private final ChangeReportStatusService changeReportStatusService;


    @Operation(summary = "신고 생성하기")
    @PostMapping("")
    public void createReportDivideRequest(@RequestBody CreateReportRequest request) {
        createReportService.execute(request);
    }

    @Operation(summary = "이미지 업로드")
    @PostMapping("/image")
    public ImageResponse uploadImage(@RequestPart(value = "images") List<MultipartFile> files) {
        return uploadImageService.execute(files);
    }
    @Operation(summary = "신고 상태 변경")
    @PatchMapping("/")
    public void updateReportStatus(@RequestBody ChangeReportStatusRequest request) {
        changeReportStatusService.execute(request);
    }
}
