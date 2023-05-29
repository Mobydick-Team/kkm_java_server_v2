package com.kkm.kkm_server_v2.domain.post.presentation.dto.response;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MyPostListResponse {
    private List<MyPostResponse> myPostResponseList;
}
