package com.kkm.kkm_server_v2.domain.location.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeSelectedLocationRequest {
    private Long locationId;
}
