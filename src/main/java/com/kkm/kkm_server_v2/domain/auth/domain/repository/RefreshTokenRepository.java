package com.kkm.kkm_server_v2.domain.auth.domain.repository;

import com.kkm.kkm_server_v2.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByUserId(String userId);
}
