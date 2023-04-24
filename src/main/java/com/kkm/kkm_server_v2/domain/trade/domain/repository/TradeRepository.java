package com.kkm.kkm_server_v2.domain.trade.domain.repository;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    @Query("select t from Trade t where t.postId = :post order by t.tradeTime desc")
    List<Trade> findAllByPostIdOrderByTradeTime(Post post);
}
