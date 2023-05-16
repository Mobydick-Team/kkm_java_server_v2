package com.kkm.kkm_server_v2.domain.user.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateAddressRequest {
    @NotBlank
    private String userId;

    @NotBlank
    private long latitude;

    @NotBlank
    private long longitude;

    @NotBlank
    private String address;

    public UpdateAddressRequest(String userId, long latitude, long longitude, String address) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }
    public User toEntity(User user){
        return User.builder()
                .userId(userId)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .imgUrl(user.getImgUrl())
                .nickname(user.getNickname())
                .role(user.getRole())
                .kkm(user.getKkm())
                .build();
    }
}
