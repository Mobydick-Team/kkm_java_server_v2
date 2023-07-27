package com.kkm.kkm_server_v2.domain.report.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReportStatus {

    REVIEWING("검토 중"),
    REJECTED("기각"),
    REPORTED("신고완료");

    private final String name;

}
