package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.feature.account.dto.AccountDetailResponse;
import com.api.sbc11mbankingapi.feature.account.dto.CreateAccountRequest;

public interface AccountService {
    AccountDetailResponse findByActNo(String actNo);
    void createNew(CreateAccountRequest createAccountRequest);
}
