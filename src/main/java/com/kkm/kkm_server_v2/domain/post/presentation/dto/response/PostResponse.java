package com.kkm.kkm_server_v2.domain.post.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Image;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {

    private Long postId;
    private String title;
    private String content;
    private int price;
    private PostCategory category;
    private PostStatus status;
    private List<String> images;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .price(post.getPrice())
                .category(post.getCategory())
                .status(post.getStatus())
                .images(post.getImageList().stream()
                        .map(Image::getUrl)
                        .collect(Collectors.toList()))
                .build();
    }

}
