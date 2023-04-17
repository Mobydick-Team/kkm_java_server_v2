package com.kkm.kkm_server_v2.domain.post.presentation;

import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.CreatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.UpdatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.ImageResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
import com.kkm.kkm_server_v2.domain.post.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final CreatePostService createPostService;
    private final UploadImageService uploadImageService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;
    private final FindPostService findPostService;
    private final FindAllPostService findAllPostService;
    private final FindByCategoryPostService findByCategoryPostService;
    private final SearchPostService searchPostService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @RequestBody CreatePostRequest request
    ) {
        createPostService.execute(request);
    }

    @PostMapping("/image")
    @ResponseStatus(HttpStatus.CREATED)
    public ImageResponse uploadImage(
            @RequestPart(value = "images") List<MultipartFile> files
    ) {
        return uploadImageService.execute(files);
    }

    @PatchMapping("/{id}")
    public void updatePost(
            @PathVariable("id") Long id,
            @RequestBody UpdatePostRequest request
    ) {
        updatePostService.execute(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(
            @PathVariable("id") Long id
    ) {
        deletePostService.execute(id);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(
            @PathVariable("id") Long id
    ) {
        return findPostService.execute(id);
    }

    @GetMapping("/list")
    public PostListResponse getAllPost(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return findAllPostService.execute(page,size);
    }

    @GetMapping("/category")
    public PostListResponse getAllPostByCategory(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("category") PostCategory category
    ) {
        return findByCategoryPostService.execute(page, size, category);
    }

    @GetMapping("/search")
    public PostListResponse searchPost(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("content") String content
    ) {
        return searchPostService.execute(page, size, content);
    }

}
