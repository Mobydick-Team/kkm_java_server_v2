package com.kkm.kkm_server_v2.domian.trade.entity.repository;

import com.kkm.kkm_server_v2.domian.trade.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
}
