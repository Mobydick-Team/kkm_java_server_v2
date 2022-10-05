package com.kkm.kkm_server_v2.Repository;

import com.kkm.kkm_server_v2.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface PostRepository extends JpaRepository<Post,Long> {


    Optional<Post> findById(Long aLong);

}
