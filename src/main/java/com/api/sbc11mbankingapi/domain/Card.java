package com.api.sbc11mbankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String holder;

    @Column(nullable = false,unique = true, length = 16)
    private String number;

    @Column(nullable = false, length = 4)
    private String cvv;

    @Column(nullable = false)
    private LocalDate issuedAt;
    @Column(nullable = false)
    private LocalDate expiryDate;
    @Column(nullable = false)
    private Boolean isDeleted;

    // Card have one Account
    // Account សំសាន់ជាងត្រូវMapped by នៅCard
    @OneToOne(mappedBy = "card")
    private Account account;

    @ManyToOne
    private CardType cardType;
}
