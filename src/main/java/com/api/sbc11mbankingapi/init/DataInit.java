package com.api.sbc11mbankingapi.init;


import com.api.sbc11mbankingapi.domain.AccountType;
import com.api.sbc11mbankingapi.domain.CardType;
import com.api.sbc11mbankingapi.domain.Role;
import com.api.sbc11mbankingapi.domain.User;
import com.api.sbc11mbankingapi.feature.account.AccountTypeRepository;
import com.api.sbc11mbankingapi.feature.auth.RoleRepository;
import com.api.sbc11mbankingapi.feature.card.CardTypeRepository;
import com.api.sbc11mbankingapi.feature.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final CardTypeRepository cardTypeRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    void init(){
        initCardTypeData();
        initAccountTypeData();
        initRoleData();
        initUserData();
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

    //
    private void initUserData(){
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setEmail("admin@bankinggmail.com");
        user.setPhoneNumber("09887877");
        user.setPassword(passwordEncoder.encode("qwer"));
        user.setPin("1234");
        user.setProfileImage("profile-admin.jpg");
        user.setNationalCardId("089858768");
        user.setGender("Male");
        user.setName("Admin");
        user.setCreatedAt(LocalDateTime.now());
        user.setDob(LocalDate.of(1999,12,20));
        user.setIsBlocked(false);
        user.setIsVerified(true);
        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(1).get());
        roles.add(roleRepository.findById(5).orElseThrow());

        user.setRoles(roles);

        //save
        userRepository.save(user);
    }

    //
    private void initRoleData(){
        //ADMIN MANAGER CUSTOMER STAFF CUSTOMER USER
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder()
                .name("USER").build());
        roles.add(Role.builder()
                .name("CUSTOMER").build());
        roles.add(Role.builder()
                .name("STAFF").build());
        roles.add(Role.builder()
                .name("MANAGER").build());
        roles.add(Role.builder()
                .name("ADMIN").build());

        roleRepository.saveAll(roles);

    }
}
