package com.kkm.kkm_server_v2.domain.jjam.presentation;

import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.request.CreateJjamRequest;
import com.kkm.kkm_server_v2.domain.jjam.service.CreateJjamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jjam")
@RequiredArgsConstructor
public class JjamController {
    private final CreateJjamService createJjamService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createJjam(@RequestBody CreateJjamRequest request) {
        createJjamService.execute(request);
    }

}
