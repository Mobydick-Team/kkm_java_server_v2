package com.kkm.kkm_server_v2.domian.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateNicknameRequest {
    @NotBlank
    private String nickname;

    @NotBlank
    private long id;

}
