package com.api.sbc11mbankingapi.feature.account;


import com.api.sbc11mbankingapi.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRespository extends JpaRepository<UserAccount, Integer> {


}
