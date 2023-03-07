package com.kkm.kkm_server_v2.domian.heart.entity.repository;

import com.kkm.kkm_server_v2.domian.heart.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
}
