package com.kkm.kkm_server_v2.domain.auth.domain.repository;

import com.kkm.kkm_server_v2.domain.auth.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
