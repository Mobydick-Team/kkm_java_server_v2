package com.kkm.kkm_server_v2.domain.report.service;

import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.ImageResponse;
import com.kkm.kkm_server_v2.domain.report.domain.ReportImage;
import com.kkm.kkm_server_v2.domain.report.domain.repository.ReportImageRepository;
import com.kkm.kkm_server_v2.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UploadReportImageService {
    private final ReportImageRepository reportImageRepository;
    private final AwsS3Service awsS3Service;

    @Transactional
    public ImageResponse execute(List<MultipartFile> files) {
        List<String> urls = awsS3Service.uploadFile(files);
        List<ReportImage> images = urls.stream().map(ReportImage::new)
                .collect(Collectors.toList());
        reportImageRepository.saveAll(images);
        return ImageResponse.builder()
                .urls(urls)
                .build();
    }
}
