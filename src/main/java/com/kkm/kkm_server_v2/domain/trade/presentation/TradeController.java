package com.kkm.kkm_server_v2.domain.trade.presentation;

import com.kkm.kkm_server_v2.domain.trade.presentation.dto.request.CreateTradeRequest;
import com.kkm.kkm_server_v2.domain.trade.service.CreateTradeService;
import com.kkm.kkm_server_v2.domain.trade.service.EndTradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
@Tag(name = "거래 서버")
public class TradeController {
    private final CreateTradeService createTradeService;
    private final EndTradeService endTradeService;

    @Operation(summary = "거래 생성하기")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrade(
            @RequestBody CreateTradeRequest request
    ) {
        createTradeService.execute(request);
    }

    @Operation(summary = "거래 끝내기")
    @PostMapping("/end/{tradeId}")
    public void endTrade(
            @PathVariable Long tradeId
    ) {
        endTradeService.execute(tradeId);
    }
}
