package com.api.sbc11mbankingapi.feature.account;

import com.api.sbc11mbankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByActNo(String actNo);
    // Select exists (select * from account where act_no = ?
    Boolean existsByActNo(String actNo);
}
