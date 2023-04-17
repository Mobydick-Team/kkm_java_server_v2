package com.kkm.kkm_server_v2.domain.user.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateUserInfoRequest {
    @NotBlank
    private String nickname;

    @NotBlank
    private String userId;

    public UpdateUserInfoRequest(String nickname, String userId) {
        this.nickname = nickname;
        this.userId = userId;
    }

    public User toEntity(User user, String imgUrl) {
        return User.builder()
                .userId(userId)
                .latitude(user.getLatitude())
                .longitude(user.getLongitude())
                .address(user.getAddress())
                .imgUrl(imgUrl)
                .nickname(nickname)
                .role(user.getRole())
                .build();
    }
}
