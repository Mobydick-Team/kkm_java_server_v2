package com.kkm.kkm_server_v2.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateAddressRequest {

    @NotBlank
    private double latitude;

    @NotBlank
    private double longitude;

    @NotBlank
    private String address;

}
