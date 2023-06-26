package com.kkm.kkm_server_v2.domain.location.service;

import com.kkm.kkm_server_v2.domain.location.domain.repository.LocationRepository;
import com.kkm.kkm_server_v2.domain.location.facade.LocationFacade;
import com.kkm.kkm_server_v2.domain.location.presentation.dto.request.CreateLocationRequest;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateLocationService {
    private final UserFacade userFacade;
    private final LocationFacade locationFacade;
    private final LocationRepository locationRepository;

    @Transactional
    public void execute(CreateLocationRequest request) {
        boolean defaultValue = false;
        User user = userFacade.getCurrentUser(false);
        if (locationFacade.countLocation(user) == 0) defaultValue = true;
        locationFacade.checkLocation(user, request.getAddress());
        locationRepository.save(request.toEntity(user, defaultValue));
    }
}
