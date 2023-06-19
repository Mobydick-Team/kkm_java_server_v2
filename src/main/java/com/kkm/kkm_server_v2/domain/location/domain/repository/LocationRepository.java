package com.kkm.kkm_server_v2.domain.location.domain.repository;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
