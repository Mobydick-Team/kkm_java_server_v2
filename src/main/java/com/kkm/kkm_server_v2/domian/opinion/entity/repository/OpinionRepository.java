package com.kkm.kkm_server_v2.domian.opinion.entity.repository;

import com.kkm.kkm_server_v2.domian.opinion.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
