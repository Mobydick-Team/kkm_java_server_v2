package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.Image;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.ImageRepository;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.ImageNotFoundException;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.CreatePostRequest;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreatePostService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void execute(CreatePostRequest request) {
        User user = userFacade.getCurrentUser(true);

        Post post = request.toEntity();
        if(!request.getUrls().isEmpty()) {
            List<Image> images = request.getUrls().stream().map(url ->
                imageRepository.findByUrl(url)
                        .orElseThrow(() -> ImageNotFoundException.EXCEPTION)
            ).peek(image -> image.setPost(post)).collect(Collectors.toList());
            post.addImage(images);
        }

        post.setAuthor(user);
        user.addPost(post);
        postRepository.save(post);
    }

}
