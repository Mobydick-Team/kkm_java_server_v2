package com.kkm.kkm_server_v2.domain.post.presentation;

import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.CreatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.request.UpdatePostRequest;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.ImageResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
import com.kkm.kkm_server_v2.domain.post.service.CreatePostService;
import com.kkm.kkm_server_v2.domain.post.service.DeletePostService;
import com.kkm.kkm_server_v2.domain.post.service.DistanceAndCategoryPostService;
import com.kkm.kkm_server_v2.domain.post.service.FindPostService;
import com.kkm.kkm_server_v2.domain.post.service.PullPostService;
import com.kkm.kkm_server_v2.domain.post.service.SearchPostService;
import com.kkm.kkm_server_v2.domain.post.service.UpdatePostService;
import com.kkm.kkm_server_v2.domain.post.service.UploadImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "게시글 서버")
public class PostController {

    private final CreatePostService createPostService;
    private final UploadImageService uploadImageService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;
    private final FindPostService findPostService;
    private final SearchPostService searchPostService;
    private final PullPostService pullPostService;
    private final DistanceAndCategoryPostService distanceAndCategoryPostService;

    @Operation(summary = "게시글 생성")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @RequestBody CreatePostRequest request
    ) {
        createPostService.execute(request);
    }

    @Operation(summary = "이미지 업로드")
    @PostMapping("/image")
    @ResponseStatus(HttpStatus.CREATED)
    public ImageResponse uploadImage(
            @RequestPart(value = "images") List<MultipartFile> files
    ) {
        return uploadImageService.execute(files);
    }

    @Operation(summary = "게시글 업데이트")
    @PatchMapping("/{id}")
    public void updatePost(
            @PathVariable("id") Long id,
            @RequestBody UpdatePostRequest request
    ) {
        updatePostService.execute(id, request);
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(
            @PathVariable("id") Long id
    ) {
        deletePostService.execute(id);
    }

    @Operation(summary = "게시글 조회")
    @GetMapping("/{id}")
    public PostResponse getPost(
            @PathVariable("id") Long id
    ) {
        return findPostService.execute(id);
    }

    @Operation(summary = "게시글 검색")
    @GetMapping("/search")
    public PostListResponse searchPost(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("content") String content,
            @RequestParam("category") PostCategory category,
            @RequestParam("distance") int distance
    ) {
        return searchPostService.execute(page, size, content, category, distance);
    }

    @Operation(summary = "게시글 끌어올리기")
    @PatchMapping("/{id}/pull")
    public void pullPost(
            @PathVariable("id") Long id
    ) {
        pullPostService.execute(id);
    }

    @Operation(summary = "게시글 카테고리 + 거리 조회")
    @GetMapping("/list")
    public PostListResponse getAllPostByCategoryAndLocation(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("category") PostCategory category,
            @RequestParam("distance") int distance
    ) {
        return distanceAndCategoryPostService.execute(page, size, category, distance);
    }

}
