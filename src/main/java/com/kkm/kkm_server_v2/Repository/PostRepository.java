package com.kkm.kkm_server_v2.Repository;

import com.kkm.kkm_server_v2.Domain.PostTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostTbl,Long> {
    List<PostTbl> findAllByUsers();

    Optional<PostTbl> findById(Long aLong);

}
