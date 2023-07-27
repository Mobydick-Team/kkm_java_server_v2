package com.kkm.kkm_server_v2.domain.report.presantation.dto.request;

import com.kkm.kkm_server_v2.domain.report.domain.Report;
import com.kkm.kkm_server_v2.domain.report.domain.enums.ReportCategory;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class CreateReportRequest {
    private Long targetId;
    private ReportCategory category;
    private List<String> urls;

    public Report toEntityWithoutImages(User reporter, User target) {
        return Report.builder()
                .reporterId(reporter.getId())
                .targetId(target.getId())
                .category(this.category)
                .build();
    }
}
