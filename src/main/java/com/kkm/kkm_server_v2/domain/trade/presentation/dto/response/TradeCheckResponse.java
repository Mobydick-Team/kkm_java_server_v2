package com.kkm.kkm_server_v2.domain.trade.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.trade.domain.enums.TradeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter @Builder
@AllArgsConstructor
public class TradeCheckResponse {

    private Long tradeId;

    private String tradeTime;

    private TradeStatus status;

    public static TradeCheckResponse of(Trade trade) {
        return TradeCheckResponse.builder()
                .tradeId(trade.getId())
                .tradeTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        .format(trade.getTradeTime()))
                .status(trade.getStatus())
                .build();
    }

}
