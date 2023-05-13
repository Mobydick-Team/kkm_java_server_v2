package com.kkm.kkm_server_v2.domain.trade.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import com.kkm.kkm_server_v2.domain.trade.domain.enums.TradeStatus;
import com.kkm.kkm_server_v2.domain.trade.domain.repository.TradeRepository;
import com.kkm.kkm_server_v2.domain.trade.exception.TradeNotFoundException;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EndTradeService {
    private final TradeRepository tradeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(Long tradeId) {
        Trade trade = tradeRepository.findById(tradeId).orElseThrow(() -> TradeNotFoundException.EXCEPTION);
        User giver = userRepository.findById(trade.getGiverId()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
        User receiver = userRepository.findById(trade.getReceiverId()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
        Post post = postRepository.findById(trade.getPostId().getPostId()).orElseThrow(() -> PostNotFoundException.EXCEPTION);
        trade.updateStatus(TradeStatus.DONE);
        post.updateStatus(PostStatus.ACTIVE);
        giver.updateTradeCount(giver.getTradeCount() + 1);
        receiver.updateTradeCount(receiver.getTradeCount() + 1);
    }
}
