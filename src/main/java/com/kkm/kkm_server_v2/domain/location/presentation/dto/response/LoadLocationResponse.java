package com.kkm.kkm_server_v2.domain.location.presentation.dto.response;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoadLocationResponse {
    private Long locationId;
    private String address;
    private Double latitude;
    private Double longitude;

    public static LoadLocationResponse of(Location location) {
        return LoadLocationResponse.builder()
                .locationId(location.getId())
                .address(location.getAddress())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }
}
