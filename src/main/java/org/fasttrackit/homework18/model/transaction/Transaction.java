package org.fasttrackit.homework18.model.transaction;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private final Long id;
    @Column
    private final String product;
    @Column
    @Enumerated(value = EnumType.STRING)
    private final TransactionType type;
    @Column
    private final double amount;
}
