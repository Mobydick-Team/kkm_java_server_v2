package com.kkm.kkm_server_v2.domain.report.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReportCategory {

    SEXUAL_HARASSMENT("성희롱, 신체 노출 및 음란물"),
    VIOLENCE("폭력, 협박 및 강요"),
    ABUSE("욕설"),
    TRANSACTION_FRAUD("거래 사기"),
    PRODUCT_DAMAGE("상품 훼손"),
    ETC("기타");

    private final String name;
}
