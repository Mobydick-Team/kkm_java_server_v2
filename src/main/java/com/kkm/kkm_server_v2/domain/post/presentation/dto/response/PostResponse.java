package com.kkm.kkm_server_v2.domain.post.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class PostResponse {

    private Long postId;
    private String title;
    private String content;
    private int price;
    private String process;
    private PostCategory category;

}
