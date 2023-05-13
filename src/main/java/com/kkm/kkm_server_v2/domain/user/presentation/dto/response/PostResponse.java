package com.kkm.kkm_server_v2.domain.user.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {
    private String title;
    private String thumbnail;
    private boolean isJjammed;
    private int price;
    private int deposit;

    public static PostResponse of(Post post, boolean isJjammed) {
        return PostResponse.builder()
                .title(post.getTitle())
                .thumbnail(post.getImageList().get(0).getUrl())
                .isJjammed(isJjammed)
                .price(post.getPrice())
                .deposit(post.getDeposit())
                .build();
    }
}
