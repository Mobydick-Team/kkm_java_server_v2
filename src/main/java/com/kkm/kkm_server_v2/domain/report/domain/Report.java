package com.kkm.kkm_server_v2.domain.report.domain;

import com.kkm.kkm_server_v2.domain.report.domain.enums.ReportCategory;
import com.kkm.kkm_server_v2.domain.report.domain.enums.ReportStatus;
import com.kkm.kkm_server_v2.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_report")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Enumerated(EnumType.STRING)
    private ReportCategory category;

    private Long reporterId;

    private Long targetId;
    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    public void updateStatus(ReportStatus status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReportImage> imageList;

    public void addImage(List<ReportImage> images) {
        images.stream().map(item ->
                getImageList().add(item)
        ).close();
    }

    @Builder
    public Report(ReportCategory category, Long reporterId, Long targetId) {
        this.category = category;
        this.reporterId = reporterId;
        this.targetId = targetId;
        this.imageList = new ArrayList<>();
        this.status = ReportStatus.REVIEWING;
    }

}
