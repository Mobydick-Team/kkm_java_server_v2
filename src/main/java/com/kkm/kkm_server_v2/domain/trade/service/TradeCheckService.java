package com.kkm.kkm_server_v2.domain.trade.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.trade.domain.repository.TradeRepository;
import com.kkm.kkm_server_v2.domain.trade.exception.TradeNotFoundException;
import com.kkm.kkm_server_v2.domain.trade.presentation.dto.response.TradeCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TradeCheckService {

    private final PostRepository postRepository;
    private final TradeRepository tradeRepository;

    @Transactional
    public TradeCheckResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Trade trade = tradeRepository.findByPostId(post)
                .orElseThrow(() -> TradeNotFoundException.EXCEPTION);

        return TradeCheckResponse.of(trade);
    }

}
