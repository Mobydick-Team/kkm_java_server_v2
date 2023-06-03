package com.kkm.kkm_server_v2.domain.user.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyPageResponse {

    private String name;
    private String profileImage;
    private String address;
    private int tradeCount;
    private int reviewCount;
    private int kkm;
    private PostListResponse myPostList;
    private PostListResponse myJjamList;

    public static MyPageResponse of(User user, PostListResponse myPostList) {
        return MyPageResponse.builder()
                .name(user.getNickname())
                .profileImage(user.getImgUrl())
                .address(user.getAddress())
                .tradeCount(user.getTradeCount())
                .reviewCount(user.getReviewSize())
                .kkm(user.getKkm())
                .myPostList(myPostList)
                .myJjamList(user.getJjamPostResponse())
                .build();
    }
}
