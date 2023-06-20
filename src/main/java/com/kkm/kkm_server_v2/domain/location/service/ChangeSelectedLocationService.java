package com.kkm.kkm_server_v2.domain.location.service;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.facade.LocationFacade;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeSelectedLocationService {
    private final UserFacade userFacade;
    private final LocationFacade locationFacade;

    @Transactional
    public void execute(Long id) {
        User user = userFacade.getCurrentUser(false);
        Location location = locationFacade.findByIdAndUserLocation(id, user);
        Location selectedLocation = locationFacade.findBySelectedAndUserLocation(user);
        locationFacade.preventSameLocation(location, selectedLocation);
        location.updateSelected(true);
        selectedLocation.updateSelected(false);
    }
}
