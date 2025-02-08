package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.feature.account.dto.AccountTypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountTypeService {
    List<AccountTypeResponse> findAll();
}
