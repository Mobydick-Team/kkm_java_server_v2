package com.kkm.kkm_server_v2.domain.report.domain.repository;

import com.kkm.kkm_server_v2.domain.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
