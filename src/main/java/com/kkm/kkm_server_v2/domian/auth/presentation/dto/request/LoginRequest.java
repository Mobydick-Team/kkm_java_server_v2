package com.kkm.kkm_server_v2.domian.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class LoginRequest {
    @NotNull
    private Long userId;

}
