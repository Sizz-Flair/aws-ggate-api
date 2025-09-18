package com.sms.ggateapi.domain.delivery.cj.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;

/**
 * ReportLabelDto 클래스
 *
 * <p>설명: 
 *
 * 작성자: akfur
 * 작성일: 2025-09-08
 */
@Builder(access = AccessLevel.PUBLIC)
public record ReportLabelDto(
        @NonNull String PRINT_LABEL1,
        @NonNull String PRINT_LABEL2,
        @NonNull String PRINT_LABEL3,
        @NonNull String PRINT_LABEL4,
        @NonNull String PRINT_LABEL5,
        @NonNull String PRINT_LABEL6,
        @NonNull String PRINT_LABEL7
) {
}
