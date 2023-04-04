package com.kkm.kkm_server_v2.domian.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    @NotBlank
    @Size(max = 38)
    private String nickname;

    @NotBlank
    private String userId;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotBlank
    private String address;

}
