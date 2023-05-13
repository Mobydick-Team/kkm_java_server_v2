package com.kkm.kkm_server_v2.domain.trade.exception;

import com.kkm.kkm_server_v2.domain.trade.exception.error.TradeErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;

public class TradeNotFoundException extends KkmException {
    public static final TradeNotFoundException EXCEPTION = new TradeNotFoundException();

    private TradeNotFoundException() {
        super(TradeErrorProperty.TRADE_NOT_FOUND);
    }
}
