package com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
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

    public static LoadUserJjamsResponse of(Post post) {
        String thumbnailUrl = post.getImageList().get(0).getUrl();
        return LoadUserJjamsResponse.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .thumbnailUrl(thumbnailUrl)
                .price(post.getPrice())
                .deposit(post.getDeposit())
                .build();
    }
}
