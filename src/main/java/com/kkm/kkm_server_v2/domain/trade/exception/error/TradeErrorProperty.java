package com.kkm.kkm_server_v2.domain.trade.exception.error;

import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum TradeErrorProperty implements ErrorProperty {
    TRADE_NOT_COMPLETED(HttpStatus.FORBIDDEN, "이전 거래가 아직 끝나지 않았습니다.");
    private final HttpStatus status;
    private final String message;
}
