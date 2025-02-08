package com.api.sbc11mbankingapi.init;


import com.api.sbc11mbankingapi.domain.AccountType;
import com.api.sbc11mbankingapi.domain.CardType;
import com.api.sbc11mbankingapi.feature.account.AccountTypeRepository;
import com.api.sbc11mbankingapi.feature.card.CardTypeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final CardTypeRepository cardTypeRepository;
    private final AccountTypeRepository accountTypeRepository;
    @PostConstruct
    void init(){
        initCardTypeData();
        initAccountTypeData();
    }

    private void initCardTypeData(){
        CardType  visa = new CardType();
        visa.setName("Visa");
        visa.setAlias("visa");
        visa.setIsDeleted(false);

        CardType masterCard = new CardType();
        masterCard.setName("Mastercard");
        masterCard.setAlias("mastercard");
        masterCard.setIsDeleted(false);

//        cardTypeRepository.save(visa);
//        cardTypeRepository.save(masterCard);

        cardTypeRepository.saveAll(List.of(visa, masterCard));
    }
    private void initAccountTypeData(){
        AccountType saving = new AccountType();
        saving.setName("Saving Account");
        saving.setAlias("saving-account");
        saving.setDescription("Saving Account");
        saving.setIsDeleted(false);

        AccountType payRoll = new AccountType();
        payRoll.setName("PayRoll Account");
        payRoll.setAlias("payroll-account");
        payRoll.setDescription("PayRoll Account");
        payRoll.setIsDeleted(false);

        AccountType current = new AccountType();
        current.setName("Current Account");
        current.setAlias("current-account");
        current.setDescription("Current Account");
        current.setIsDeleted(true);

        accountTypeRepository.saveAll(List.of( saving,payRoll,current));
    }
}
