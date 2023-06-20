package com.kkm.kkm_server_v2.domain.location.facade;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.domain.repository.LocationRepository;
import com.kkm.kkm_server_v2.domain.location.exception.LocationAlreadyExistException;
import com.kkm.kkm_server_v2.domain.location.exception.LocationAlreadySelectedException;
import com.kkm.kkm_server_v2.domain.location.exception.LocationCountExceedException;
import com.kkm.kkm_server_v2.domain.location.exception.LocationNotFoundException;
import com.kkm.kkm_server_v2.domain.location.exception.LocationSelectedCannotDeleteException;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class LocationFacade {
    private final LocationRepository locationRepository;

    @Transactional(readOnly = true)
    public int countLocation(User user) {
        int count = locationRepository.findAllByUserLocation(user).size();
        if (count >= 3) {
            throw LocationCountExceedException.EXCEPTION;
        }
        return count;
    }

    @Transactional(readOnly = true)
    public void checkLocation(User user, String address) {
        locationRepository.findByUserLocationAndAddress(user, address).ifPresent(location -> {
            throw LocationAlreadyExistException.EXCEPTION;
        });
    }

    @Transactional(readOnly = true)
    public Location findByIdAndUserLocation(Long id, User user) {
        return locationRepository.findByIdAndUserLocation(id, user)
                .orElseThrow(() -> LocationNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public Location findBySelectedAndUserLocation(User user) {
        return locationRepository.findByUserLocationAndSelected(user, true)
                .orElseThrow(() -> LocationNotFoundException.EXCEPTION);
    }

    public void preventSameLocation(Location location, Location selectedLocation) {
        if (location.equals(selectedLocation)) {
            throw LocationAlreadySelectedException.EXCEPTION;
        }
    }

    public void deleteLocationCheck(Location location) {
        if (location.isSelected()) {
            throw LocationSelectedCannotDeleteException.EXCEPTION;
        }
    }
}
