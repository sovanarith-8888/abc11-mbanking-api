package com.api.sbc11mbankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sransactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @ManyToOne
    private Account owner;

    @ManyToOne
    private Account receiver;

    private String paymentReceiver;// StudentId, BillNo phone....

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 30)
    private String transactionType; // payment, transfer

    @Column(nullable = false)
    private LocalDateTime transactionAt;

    @Column(nullable = false)
    private Boolean status;
    @Column(nullable = false)
    private Boolean isDeleted;

}
