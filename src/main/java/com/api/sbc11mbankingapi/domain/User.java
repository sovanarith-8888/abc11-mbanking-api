package com.api.sbc11mbankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private String uuid;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, unique = true, length = 6)
    private String pin;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 50)
    private String nationalCardId;

    @Column(nullable = false, unique = true, length = 50)
    private String phoneNumber;

    @Column(nullable = false, unique = false, length = 50)
    private String name;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false, length = 50)
    private String gender;

    private String profileImage;

    @Column(unique = true, length = 50)
    private String studentCardId;

    private String position;

    private String companyName;

    private String employeeType;

    private String cityOrProvince;

    private String khanOrDistrict;

    private String sangkatOrCommune;

    private String street;

    private String village;

    private LocalDateTime createdAt;

    private Boolean isVerified;

    private Boolean isBlocked;

    private BigDecimal monthlyIncomeRange;

    private BigDecimal mainSourceOfIncome;

    // Security
    private Boolean isDeleted;

    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

//    @OneToMany(mappedBy = "user")
//    private List<Account> accounts;

    @OneToMany(mappedBy = "user")
    private List<UserAccount> userAccounts;

}
