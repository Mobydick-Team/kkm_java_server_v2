package com.kkm.kkm_server_v2.domain.post.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostRequest {

    private String title;
    private String content;
    private int price;
    private String process;
    private PostCategory category;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .process(this.process)
                .category(this.category)
                .build();
    }

}