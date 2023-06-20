package com.kkm.kkm_server_v2.domain.location.presentation;

import com.kkm.kkm_server_v2.domain.location.presentation.dto.request.ChangeSelectedLocationRequest;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.request.CreateLocationRequest;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.request.UpdateAddressRequest;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.response.LoadLocationListResponse;
import com.kkm.kkm_server_v2.domain.location.service.ChangeSelectedLocationService;
import com.kkm.kkm_server_v2.domain.location.service.CreateLocationService;
import com.kkm.kkm_server_v2.domain.location.service.LoadLocationService;
import com.kkm.kkm_server_v2.domain.location.service.UpdateAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Tag(name = "주소 서버")
public class LocationController {
    private final CreateLocationService createLocationService;
    private final UpdateAddressService updateAddressService;
    private final LoadLocationService loadLocationService;
    private final ChangeSelectedLocationService changeSelectedLocationService;

    @Operation(summary = "주소 등록")
    @PostMapping("/add")
    public void AddLocation(@RequestBody CreateLocationRequest request) {
        createLocationService.execute(request);
    }

    @Operation(summary = "주소 업데이트")
    @PutMapping("/update")
    public void UpdateAddress(@RequestBody @Valid UpdateAddressRequest request) {
        updateAddressService.execute(request);
    }

    @Operation(summary = "주소 조회")
    @GetMapping("/my")
    public LoadLocationListResponse getLocationList() {
        return loadLocationService.execute();
    }

    @Operation(summary = "선택 주소 변경")
    @PostMapping("/change")
    public void changeLocation(@RequestBody ChangeSelectedLocationRequest request) {
        changeSelectedLocationService.execute(request);
    }
}
