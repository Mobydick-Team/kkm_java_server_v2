package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.facade.LocationFacade;
import com.kkm.kkm_server_v2.domain.post.domain.PostImage;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostImageRepository;
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
    private final PostImageRepository imageRepository;
    private final LocationFacade locationFacade;

    @Transactional
    public void execute(CreatePostRequest request) {
        User user = userFacade.getCurrentUser(true);
        Location location = locationFacade.findBySelectedAndUserLocation(user);
        Post post = request.toEntity();
        if (!request.getUrls().isEmpty()) {
            List<PostImage> images = request.getUrls().stream().map(url ->
                    imageRepository.findByUrl(url)
                            .orElseThrow(() -> ImageNotFoundException.EXCEPTION)
            ).peek(image -> image.setPost(post)).collect(Collectors.toList());
            post.addImage(images);
        }
        post.addAddress(location.getLatitude(), location.getLongitude(), location.getAddress());
        post.setAuthor(user);
        user.addPost(post);
        postRepository.save(post);
    }

}
