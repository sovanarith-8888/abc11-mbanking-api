package com.api.sbc11mbankingapi.mapper;

import com.api.sbc11mbankingapi.domain.AccountType;
import com.api.sbc11mbankingapi.feature.account.dto.AccountTypeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {
    List<AccountTypeResponse> toAccountTypeResponseList(List<AccountType> accountTypes);
}
