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
    private String process;
    private PostCategory category;
    private List<String> urls;
    private boolean crumpled; // 구겨짐
    private boolean discoloration; // 변색
    private boolean pollution; // 오염
    private boolean ripped; // 찢어짐

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .deposit(this.deposit)
                .process(this.process)
                .category(this.category)
                .crumpled(this.crumpled)
                .discoloration(this.discoloration)
                .pollution(this.pollution)
                .ripped(this.ripped)
                .build();
    }

}
