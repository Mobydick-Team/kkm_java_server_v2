package com.kkm.kkm_server_v2.domain.post.presentation;

import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.CreatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.UpdatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.ImageResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
import com.kkm.kkm_server_v2.domain.post.service.CreatePostService;
import com.kkm.kkm_server_v2.domain.post.service.DeletePostService;
import com.kkm.kkm_server_v2.domain.post.service.DistancePostService;
import com.kkm.kkm_server_v2.domain.post.service.FindAllPostService;
import com.kkm.kkm_server_v2.domain.post.service.FindByCategoryPostService;
import com.kkm.kkm_server_v2.domain.post.service.FindPostService;
import com.kkm.kkm_server_v2.domain.post.service.PullPostService;
import com.kkm.kkm_server_v2.domain.post.service.SearchPostService;
import com.kkm.kkm_server_v2.domain.post.service.UpdatePostService;
import com.kkm.kkm_server_v2.domain.post.service.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
    private final DistancePostService distancePostService;
    private final PullPostService pullPostService;

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

    @GetMapping("/distance")
    public PostListResponse distancePost(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("longitude") double longitude,
            @RequestParam("latitude") double latitude,
            @RequestParam("distance") int distance
    ) {
        return distancePostService.execute(page, size, longitude, latitude, distance);
    }

    @PatchMapping("/{id}/pull")
    public void pullPost(
            @PathVariable("id") Long id
    ) {
        pullPostService.execute(id);
    }

}
