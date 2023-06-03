package com.kkm.kkm_server_v2.domain.trade.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TradeStatus {
    DOING("거래 중"),
    DONE("거래 완료");
    private final String name;
}
