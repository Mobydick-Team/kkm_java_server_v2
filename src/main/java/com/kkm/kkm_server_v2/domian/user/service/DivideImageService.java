package com.kkm.kkm_server_v2.domian.user.service;

import com.kkm.kkm_server_v2.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DivideImageService {
    private final AwsS3Service awsS3Service;

    public String execute(MultipartFile profileImg) {
        List<MultipartFile> list = null;
        list.add(profileImg);
        List<String> imgList = awsS3Service.uploadFile(list);
        return imgList.get(0);
    }
}
