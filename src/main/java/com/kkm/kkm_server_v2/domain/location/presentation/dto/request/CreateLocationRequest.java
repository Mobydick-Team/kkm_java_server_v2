package com.kkm.kkm_server_v2.domain.location.presentation.dto.request;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateLocationRequest {
    private String address;
    private double latitude;
    private double longitude;

    public Location toEntity(User user, boolean defaultValue) {
        return Location.builder()
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .userLocation(user)
                .selected(defaultValue)
                .build();
    }
}
