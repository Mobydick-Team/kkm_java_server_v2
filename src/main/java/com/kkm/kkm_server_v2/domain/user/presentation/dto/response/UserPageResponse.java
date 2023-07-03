package com.kkm.kkm_server_v2.domain.user.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPageResponse {
    private String name;
    private String profileImage;
    private String address;
    private int tradeCount;
    private int reviewCount;
    private int kkm;
    private PostListResponse userPostList;

    public static UserPageResponse of(User user, PostListResponse userPostList, String address) {
        return UserPageResponse.builder()
                .name(user.getNickname())
                .profileImage(user.getImgUrl())
                .address(address)
                .tradeCount(user.getTradeCount())
                .reviewCount(user.getReviewSize())
                .kkm(user.getKkm())
                .userPostList(userPostList)
                .build();
    }
}
