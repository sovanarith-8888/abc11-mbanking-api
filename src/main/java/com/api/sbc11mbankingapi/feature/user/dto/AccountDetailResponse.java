package com.api.sbc11mbankingapi.feature.user.dto;

import java.math.BigDecimal;

public record AccountDetailResponse(
        String aliasName,
        String actNo,
        BigDecimal balance,
        BigDecimal transferLimit,
        Boolean isHidden
) {
}
