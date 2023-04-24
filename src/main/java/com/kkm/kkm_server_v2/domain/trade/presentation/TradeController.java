package com.kkm.kkm_server_v2.domain.trade.presentation;

import com.kkm.kkm_server_v2.domain.trade.presentation.dto.request.CreateTradeRequest;
import com.kkm.kkm_server_v2.domain.trade.service.CreateTradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
public class TradeController {
    private final CreateTradeService createTradeService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrade(
            @RequestBody CreateTradeRequest request
    ) {
        createTradeService.execute(request);
    }
}
