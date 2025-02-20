package com.api.sbc11mbankingapi.feature.user;

import com.api.sbc11mbankingapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    // Derived query method
    Boolean existsByNationalCardId(String nationalId);

    Optional<User> findByEmail(String email);

    // JPQL = Jakarta Persistent Query Language
    //Query(value = "SELECT EXISTS (SELECT * FROM users WHERE national_card_id = ?1)", nativeQuery = true)// is write native it mean sql
    @Query(value = "SELECT EXISTS (SELECT users FROM User users WHERE users.nationalCardId = ?1)")
    //@Query(value = "SELECT EXISTS (SELECT u FROM User AS u WHERE u.nationalCardId = ?1)")
    Boolean isNationalCardIdExisted(String nationalCardId);

    Boolean existsByPhoneNumber(String phoneNumber);

    Boolean existsByEmail(String email);
}
