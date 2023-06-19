package com.kkm.kkm_server_v2.domain.location.presentation;

import com.kkm.kkm_server_v2.domain.location.presentation.dto.request.CreateLocationRequest;
import com.kkm.kkm_server_v2.domain.location.service.CreateLocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Tag(name = "주소 서버")
public class LocationController {
    private final CreateLocationService createLocationService;

    @Operation(summary = "주소 등록")
    @PostMapping("/add")
    public void AddLocation(@RequestBody CreateLocationRequest request) {
        createLocationService.execute(request);
    }
}
