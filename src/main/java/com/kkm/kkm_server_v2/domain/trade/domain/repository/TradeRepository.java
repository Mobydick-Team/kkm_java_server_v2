package com.kkm.kkm_server_v2.domain.trade.domain.repository;

import com.kkm.kkm_server_v2.domain.trade.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
