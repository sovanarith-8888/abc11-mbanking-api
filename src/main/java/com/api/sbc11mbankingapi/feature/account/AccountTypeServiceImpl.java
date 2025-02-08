package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.domain.AccountType;
import com.api.sbc11mbankingapi.feature.account.dto.AccountTypeResponse;
import com.api.sbc11mbankingapi.mapper.AccountTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService{

    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeMapper accountTypeMapper;
    @Override
    public List<AccountTypeResponse> findAll() {
        List<AccountType> accountTypes =accountTypeRepository.findAll();

        return accountTypeMapper.toAccountTypeResponseList(accountTypes);
    }
}
