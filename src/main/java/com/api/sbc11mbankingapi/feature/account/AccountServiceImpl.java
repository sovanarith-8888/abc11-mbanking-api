package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.domain.Account;
import com.api.sbc11mbankingapi.domain.AccountType;
import com.api.sbc11mbankingapi.domain.User;
import com.api.sbc11mbankingapi.domain.UserAccount;
import com.api.sbc11mbankingapi.feature.account.dto.AccountDetailResponse;
import com.api.sbc11mbankingapi.feature.account.dto.CreateAccountRequest;
import com.api.sbc11mbankingapi.feature.user.UserRepository;
import com.api.sbc11mbankingapi.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountTypeRepository accountTypeRepository;
    private final UserRepository userRepository;
    private final UserAccountRespository userAccountRespository;

    @Override
    public AccountDetailResponse findByActNo(String actNo) {
        Account account =accountRepository.findByActNo(actNo)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND),"Account does not exist"));
        return accountMapper.toAccountDetailResponse(account);
    }

    @Override
    public void createNew(CreateAccountRequest createAccountRequest) {

        // Validate account type
        AccountType accountType = accountTypeRepository.findByAlias(createAccountRequest.accountTypeAlias())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account type not found"));


        // Validate user phone number
        User user = userRepository.findByPhoneNumber(createAccountRequest.phoneNumber())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone number not found"));

        // Validate account number
        if(accountRepository.existsByActNo(createAccountRequest.actNo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account No already exists");
        }
        Account account = accountMapper.fromCreateAccountRequest(createAccountRequest);
        account.setTransferLimit(BigDecimal.valueOf(5000));
        account.setAliasName("");
        account.setAccountType(accountType);
        account.setIsDeleted(false);
        account.setIsHidden(false);

        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        userAccount.setAccount(account);
        userAccount.setCreatedAt(LocalDateTime.now());
        userAccount.setIsDeleted(false);
        userAccount.setIsDeleted(false);

        accountRepository.save(account);
        userAccountRespository.save(userAccount);
    }
}
