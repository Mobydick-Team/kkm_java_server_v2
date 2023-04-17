package com.kkm.kkm_server_v2.domain.post.domain.repository;

import com.kkm.kkm_server_v2.domain.post.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByUrl(String url);

}
