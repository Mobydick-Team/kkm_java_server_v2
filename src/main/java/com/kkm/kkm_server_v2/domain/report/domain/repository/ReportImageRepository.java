package com.kkm.kkm_server_v2.domain.report.domain.repository;

import com.kkm.kkm_server_v2.domain.report.domain.ReportImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportImageRepository extends JpaRepository<ReportImage, Long> {
    Optional<ReportImage> findByUrl(String url);

}
