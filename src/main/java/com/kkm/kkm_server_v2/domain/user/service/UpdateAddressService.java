package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.request.UpdateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAddressService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateAddressRequest request) {
        User user = userFacade.getCurrentUser();
        user.updateAddress(request.getAddress(), request.getLatitude(), request.getLongitude());
    }
}
