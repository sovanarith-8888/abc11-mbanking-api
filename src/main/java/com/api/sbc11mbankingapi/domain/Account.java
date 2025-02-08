package com.api.sbc11mbankingapi.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String aliasName;
    @Column(length = 9, nullable = false, unique = true)
    private String actNo;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private BigDecimal transferLimit;

    @Column(nullable = false)
    private Boolean isHidden;

    @Column(nullable = false)
    private Boolean isDeleted;

    //Join Column
    @ManyToOne
    private AccountType accountType;

    // Account have one Card
    @OneToOne
    private Card card;

//    @ManyToOne
//    @JoinTable(name = "user_accounts",
//    joinColumns = @JoinColumn(name = "account_id",referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
//    private User user;

    @OneToOne(mappedBy = "account")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "owner")
    private List<Transaction> transactionOfOwner;

}
