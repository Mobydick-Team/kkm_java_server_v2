package com.kkm.kkm_server_v2.domian.report.entity.repository;

import com.kkm.kkm_server_v2.domian.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
