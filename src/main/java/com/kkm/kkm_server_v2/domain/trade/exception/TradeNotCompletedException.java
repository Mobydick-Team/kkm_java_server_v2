package com.kkm.kkm_server_v2.domain.trade.exception;

import com.kkm.kkm_server_v2.domain.trade.exception.error.TradeErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class TradeNotCompletedException extends KkmException {
    public static final TradeNotCompletedException EXCEPTION = new TradeNotCompletedException();

    private TradeNotCompletedException() {
        super(TradeErrorProperty.TRADE_NOT_COMPLETED);
    }
}
