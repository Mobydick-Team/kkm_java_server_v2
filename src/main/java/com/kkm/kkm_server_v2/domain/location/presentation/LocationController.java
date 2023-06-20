package com.kkm.kkm_server_v2.domain.location.presentation;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("")
    public void AddLocation(@RequestBody CreateLocationRequest request) {
        createLocationService.execute(request);
    }

    @Operation(summary = "주소 업데이트")
    @PatchMapping("/{id}")
    public void UpdateAddress(@PathVariable("id") Long id, @RequestBody @Valid UpdateAddressRequest request) {
        updateAddressService.execute(request, id);
    }

    @Operation(summary = "주소 조회")
    @GetMapping("")
    public LoadLocationListResponse getLocationList() {
        return loadLocationService.execute();
    }

    @Operation(summary = "선택 주소 변경")
    @PostMapping("/{id}")
    public void changeLocation(@PathVariable("id") Long id) {
        changeSelectedLocationService.execute(id);
    }
    @Operation(summary = "주소 삭제")
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") Long id) {
        changeSelectedLocationService.execute(id);
    }
}
