package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DivideImageService {
    private final AwsS3Service awsS3Service;

    public String execute(List<MultipartFile> images) {
        List<String> imgList = awsS3Service.uploadFile(images);
        return imgList.get(0);
    }
}
