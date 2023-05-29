package com.kkm.kkm_server_v2.domain.trade.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.trade.domain.enums.TradeStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTradeRequest {
    private Long postId;
    private Long giverId;
    private Long receiverId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tradeTime;

    public Trade toEntity(Post post) {
        return Trade.builder()
                .giverId(this.giverId)
                .receiverId(this.receiverId)
                .postId(post)
                .tradeTime(this.tradeTime)
                .status(TradeStatus.DOING)
                .build();
    }
}
