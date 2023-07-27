package com.kkm.kkm_server_v2.domain.post.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.PostImage;
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
public class PostDetailResponse {
    private Long postId;
    private String title;
    private String content;
    private int price;
    private int deposit;
    private PostCategory category;
    private PostStatus status;
    private List<String> images;
    private String name;
    private String profileImage;
    private boolean isLike;
    private String location;

    public static PostDetailResponse of(Post post, boolean isLike) {
        return PostDetailResponse.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .price(post.getPrice())
                .deposit(post.getDeposit())
                .category(post.getCategory())
                .status(post.getStatus())
                .images(post.getImageList().stream()
                        .map(PostImage::getUrl)
                        .collect(Collectors.toList()))
                .name(post.getAuthor().getNickname())
                .profileImage(post.getAuthor().getImgUrl())
                .isLike(isLike)
                .location(post.getAddress())
                .build();
    }
}
