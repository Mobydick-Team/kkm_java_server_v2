package com.kkm.kkm_server_v2.domain.post.facade;

import com.kkm.kkm_server_v2.domain.post.domain.Image;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostFacade {

    private final PostRepository postRepository;
    private final AwsS3Service awsS3Service;

    @Transactional(readOnly = true)
    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }
    public void deleteImages(Post post) {
        List<String> imgUrls = post.getImageList().stream()
                .map(Image::getUrl)
                .collect(Collectors.toList());
        awsS3Service.deleteFiles(imgUrls);
    }

}
