package com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoadUserJjamsResponse {
    private Long postId;
    private String title;
    private String thumbnailUrl;
    private int price;
    private int deposit;
    private PostStatus status;
    private String userImgUrl;

    public static LoadUserJjamsResponse of(Post post, PostStatus status) {
        return LoadUserJjamsResponse.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .thumbnailUrl(post.getImageList().get(0).getUrl())
                .price(post.getPrice())
                .deposit(post.getDeposit())
                .status(status)
                .userImgUrl(post.getAuthor().getImgUrl())
                .build();
    }
}
