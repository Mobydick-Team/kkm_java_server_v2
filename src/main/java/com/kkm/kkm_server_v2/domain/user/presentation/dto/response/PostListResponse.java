package com.kkm.kkm_server_v2.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostListResponse {
    private List<PostResponse> postResponseList;
}
