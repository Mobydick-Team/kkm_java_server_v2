package com.kkm.kkm_server_v2.domain.post.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {
    private Long postId;
    private String title;
    private String content;
    private int price;
    private int deposit;
    private PostCategory category;
    private PostStatus status;
    private String thumbnail;
    private String name;
    private String profileImage;
    private boolean isLike;
    private String location;


    public static PostResponse of(Post post, boolean isLike) {
        return PostResponse.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .price(post.getPrice())
                .deposit(post.getDeposit())
                .category(post.getCategory())
                .status(post.getStatus())
                .thumbnail(post.getImageList().get(0).getUrl())
                .name(post.getAuthor().getNickname())
                .profileImage(post.getAuthor().getImgUrl())
                .isLike(isLike)
                .location(post.getAddress())
                .build();
    }

}
