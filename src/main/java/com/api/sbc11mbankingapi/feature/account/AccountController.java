package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.feature.account.dto.AccountDetailResponse;
import com.api.sbc11mbankingapi.feature.account.dto.CreateAccountRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{actNo}")
    AccountDetailResponse findByActNo(@PathVariable String actNo) {
        return accountService.findByActNo(actNo);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNew(@Valid @RequestBody CreateAccountRequest request) {
        accountService.createNew(request);
    }
}
