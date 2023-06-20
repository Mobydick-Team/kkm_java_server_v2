package com.kkm.kkm_server_v2.domain.location.service;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.facade.LocationFacade;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.request.UpdateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAddressService {
    private final UserFacade userFacade;
    private final LocationFacade locationFacade;

    @Transactional
    public void execute(UpdateAddressRequest request) {
        User user = userFacade.getCurrentUser(false);
        Location location = locationFacade.findByIdAndUserLocation(request.getLocationId(), user);
        location.updateLocation(request.getAddress(), request.getLatitude(), request.getLongitude());
    }
}
