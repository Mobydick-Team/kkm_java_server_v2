package com.kkm.kkm_server_v2.domain.user.domain.repository;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsUserByNickname(String nickname);

    boolean existsUserByUserId(String userId);

    Optional<User> findByUserId(String userId);

    Optional<User> findByNickname(String nickname);

    @Query(value = "SELECT * FROM tb_user u " +
            "JOIN tb_post p ON u.id = p.fk_user " +
            "JOIN tb_jjam j ON u.id = j.fk_user " +
            "JOIN tb_review r ON u.id = r.fk_user " +
            "WHERE id = :id",
        nativeQuery = true)
    Optional<User> findUserById(Long id);

}
