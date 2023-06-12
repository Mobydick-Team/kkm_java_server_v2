package com.kkm.kkm_server_v2.domain.post.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdatePostRequest {

    private String title;
    private String content;
    private int price;
    private int deposit;
    private PostCategory category;

}
