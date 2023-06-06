package org.fasttrackit.homework18.model.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Transaction {
    private final long id;
    private final String product;
    private final TransactionType type;
    private final double amount;
}
