package com.kkm.kkm_server_v2.domain.jjam.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateJjamRequest {

    private Long postId;
}
