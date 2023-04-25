package com.kkm.kkm_server_v2.domain.trade.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostStatus;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.exception.PostNotFoundException;
import com.kkm.kkm_server_v2.domain.trade.domain.repository.TradeRepository;
import com.kkm.kkm_server_v2.domain.trade.exception.TradeNotCompletedException;
import com.kkm.kkm_server_v2.domain.trade.presentation.dto.request.CreateTradeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTradeService {
    private final PostRepository postRepository;
    private final TradeRepository tradeRepository;
    private final VerifyTradeService verifyTradeService;

    @Transactional
    public void execute(CreateTradeRequest request) {
        Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> PostNotFoundException.EXCEPTION);
        if (verifyTradeService.execute(post).equals(PostStatus.ACTIVE)) {
            tradeRepository.save(request.toEntity(post));
        } else throw TradeNotCompletedException.EXCEPTION;
    }
}
