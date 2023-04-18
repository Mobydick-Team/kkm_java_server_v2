package com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class LoadUserJjamsListResponse {
    List<LoadUserJjamsResponse> list;
}
