package com.api.sbc11mbankingapi.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
@Builder
public class ErrorDetailResponse<T> {
    private String code;
    private T description;
}
