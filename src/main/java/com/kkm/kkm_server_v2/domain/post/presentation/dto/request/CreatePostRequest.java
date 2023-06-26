package com.kkm.kkm_server_v2.domain.post.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostRequest {

    private String title;
    private String content;
    private int price;
    private int deposit;
    private PostCategory category;
    private List<String> urls;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .deposit(this.deposit)
                .category(this.category)
                .build();
    }

}
