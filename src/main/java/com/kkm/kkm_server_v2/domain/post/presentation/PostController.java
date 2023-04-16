package com.kkm.kkm_server_v2.domain.post.presentation;

import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.CreatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.UpdatePostRequest;
import com.kkm.kkm_server_v2.domain.post.service.CreatePostService;
import com.kkm.kkm_server_v2.domain.post.service.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @RequestBody CreatePostRequest request
    ) {
        createPostService.execute(request);
    }

    @PatchMapping("/{id}")
    public void updatePost(
            @PathVariable("id") Long id,
            @RequestBody UpdatePostRequest request
    ) {
        updatePostService.execute(id, request);
    }

}
