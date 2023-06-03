package com.kkm.kkm_server_v2.domain.trade.service;

import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class IsEmptyTradeListService {
    public boolean execute(List<Trade> tradeList){
        return tradeList.equals(Collections.emptyList());
    }
}
