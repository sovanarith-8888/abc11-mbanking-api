package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.domain.Account;
import com.api.sbc11mbankingapi.domain.AccountType;
import com.api.sbc11mbankingapi.feature.account.dto.AccountDetailResponse;
import com.api.sbc11mbankingapi.feature.account.dto.CreateAccountRequest;
import com.api.sbc11mbankingapi.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountTypeRepository accountTypeRepository;

    @Override
    public AccountDetailResponse findByActNo(String actNo) {
        return null;
    }

    @Override
    public void createNew(CreateAccountRequest createAccountRequest) {

        AccountType accountType = accountTypeRepository.findByAlias(createAccountRequest.accountTypeAlias())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account type not found"));


        if(accountRepository.existsByActNo(createAccountRequest.actNo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account No already exists");
        }
        Account account = accountMapper.fromCreateAccountRequest(createAccountRequest);
        account.setTransferLimit(BigDecimal.valueOf(5000));
        account.setAliasName("");
        account.setAccountType(accountType);
        account.setIsDeleted(false);
        account.setIsHidden(false);

        accountRepository.save(account);
    }
}
