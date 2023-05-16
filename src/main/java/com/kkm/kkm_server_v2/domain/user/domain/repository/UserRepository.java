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

    @Query(value = "SELECT u FROM User u JOIN FETCH u.postList JOIN FETCH u.jjamList JOIN FETCH u.reviewList WHERE u.userId=:userId",
            nativeQuery = true)
    User fetchFindByUserId(String userId);
}
