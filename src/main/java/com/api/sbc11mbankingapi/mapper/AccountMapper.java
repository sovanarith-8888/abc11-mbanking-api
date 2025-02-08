package com.api.sbc11mbankingapi.mapper;

import com.api.sbc11mbankingapi.domain.Account;
import com.api.sbc11mbankingapi.feature.account.dto.AccountDetailResponse;
import com.api.sbc11mbankingapi.feature.account.dto.CreateAccountRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDetailResponse toAccountDetailResponse(Account account);
    Account fromCreateAccountRequest(CreateAccountRequest createAccountRequest);
}
