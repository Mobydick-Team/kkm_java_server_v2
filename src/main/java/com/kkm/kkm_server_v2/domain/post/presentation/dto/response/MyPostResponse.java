package com.kkm.kkm_server_v2.domain.post.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import lombok.Builder;

@Builder
public class MyPostResponse {
    private String title;
    private String thumbnail;
    private boolean isJjammed;
    private int price;
    private int deposit;

    public static MyPostResponse of(Post post, boolean isJjammed) {
        return MyPostResponse.builder()
                .title(post.getTitle())
                .thumbnail(post.getImageList().get(0).getUrl())
                .isJjammed(isJjammed)
                .price(post.getPrice())
                .deposit(post.getDeposit())
                .build();
    }
}
