package com.kkm.kkm_server_v2.domain.user.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.user.domain.Role;
import com.kkm.kkm_server_v2.domain.user.domain.User;
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


    public User toEntityUser(String imgUrl) {
        return User.builder()
                .userId(userId)
                .nickname(nickname)
                .imgUrl(imgUrl)
                .role(Role.USER)
                .kkm(0)
                .build();
    }
    public User toEntityUserWithoutImg() {
        return User.builder()
                .userId(userId)
                .nickname(nickname)
                .role(Role.USER)
                .kkm(0)
                .build();
    }
    public Location toEntityLocation(User user, boolean defaultValue) {
        return Location.builder()
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .userLocation(user)
                .selected(defaultValue)
                .build();
    }
}
