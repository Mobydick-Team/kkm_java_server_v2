package com.kkm.kkm_server_v2.domain.location.service;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.domain.repository.LocationRepository;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.response.LoadLocationListResponse;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.response.LoadLocationResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadLocationService {
    private final UserFacade userFacade;
    private final LocationRepository locationRepository;

    @Transactional
    public LoadLocationListResponse execute() {
        User user = userFacade.getCurrentUser(false);
        List<Location> locationList = locationRepository.findAllByUserLocation(user);
        return LoadLocationListResponse.builder()
                .locationList(locationList.stream().map(LoadLocationResponse::of).collect(Collectors.toList()))
                .build();
    }
}
