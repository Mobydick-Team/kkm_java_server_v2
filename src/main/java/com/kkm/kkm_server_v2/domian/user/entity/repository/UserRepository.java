package com.kkm.kkm_server_v2.domian.user.entity.repository;

import com.kkm.kkm_server_v2.domian.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByKId(String k_id);
}
