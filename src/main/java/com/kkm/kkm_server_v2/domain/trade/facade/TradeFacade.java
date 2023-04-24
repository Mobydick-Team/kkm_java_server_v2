package com.kkm.kkm_server_v2.domain.trade.facade;

import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TradeFacade {

    @Transactional
    public Trade getRecentTrade(List<Trade> tradeList) {
        return tradeList.get(0);
    }
}
