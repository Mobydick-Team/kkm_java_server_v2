package com.kkm.kkm_server_v2.domain.location.domain.repository;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByUserLocation(User user);
    Optional<Location> findByUserLocationAndAddress(User user, String address);
    Optional<Location> findByIdAndUserLocation(Long id, User user);
    Optional<Location> findByUserLocationAndSelected(User user, boolean selected);
}
