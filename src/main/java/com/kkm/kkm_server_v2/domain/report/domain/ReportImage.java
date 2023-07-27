package com.kkm.kkm_server_v2.domain.report.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_report_image")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_report")
    private Report report;

    public void setReport(Report report) {
        this.report = report;
    }

    @Builder
    public ReportImage(String url) {
        this.url = url;
    }
}
