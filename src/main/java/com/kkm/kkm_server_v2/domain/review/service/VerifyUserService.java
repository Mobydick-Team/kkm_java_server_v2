package com.kkm.kkm_server_v2.domain.review.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.review.exception.ReviewAccessWrongException;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.trade.domain.repository.TradeRepository;
import com.kkm.kkm_server_v2.domain.trade.exception.TradeNotCompletedException;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.sun.istack.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VerifyUserService {
    private final PostRepository postRepository;
    private final TradeRepository tradeRepository;

    @Transactional
    public Trade execute(User user, Long sourceId) {
        Post post = postRepository.findById(sourceId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        Trade trade = tradeRepository.findByPostIdAndReceiverId(post, user.getId());
        if (trade == null) throw ReviewAccessWrongException.EXCEPTION;
        System.out.println("trade : "+ trade.getTradeTime());
        System.out.println("now : "+ LocalDateTime.now());
        if (trade.getTradeTime().isBefore(LocalDateTime.now())) throw TradeNotCompletedException.EXCEPTION;
        return trade;
    }
}
