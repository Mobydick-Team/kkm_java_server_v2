package com.kkm.kkm_server_v2.domain.trade.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.trade.domain.repository.TradeRepository;
import com.kkm.kkm_server_v2.domain.trade.facade.TradeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VerifyTradeService {
    private final TradeRepository tradeRepository;
    private final IsEmptyTradeListService isEmptyTradeListService;
    private final TradeFacade tradeFacade;

    @Transactional
    public PostStatus execute(Post post) {
        List<Trade> tradeList = tradeRepository.findAllByPostIdOrderByTradeTime(post);
        if (!isEmptyTradeListService.execute(tradeList)) {
            if (tradeFacade.getRecentTrade(tradeList).getTradeTime().isBefore(LocalDateTime.now()))
                return PostStatus.DEACTIVATED;
        }
        return PostStatus.ACTIVE;
    }
}
