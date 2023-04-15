package com.kkm.kkm_server_v2.domian.user.domain.repository;

import com.kkm.kkm_server_v2.domian.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByNickname(String nickname);

    boolean existsUserByUserId(String userId);

    Optional<User> findByUserId(String userId);
    Optional<User> findByNickname(String nickname);
}
