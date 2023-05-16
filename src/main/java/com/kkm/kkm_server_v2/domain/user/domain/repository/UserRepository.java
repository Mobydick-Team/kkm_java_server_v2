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

    @Query("SELECT u FROM User u JOIN FETCH u.reviewList JOIN FETCH u.jjamList WHERE u.userId = :userId")
    Optional<User> findByUserIdFetchJoin(String userId);

}
