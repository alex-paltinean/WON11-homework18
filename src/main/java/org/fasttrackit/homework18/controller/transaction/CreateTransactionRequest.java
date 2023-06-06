package org.fasttrackit.homework18.controller.transaction;

import org.fasttrackit.homework18.model.transaction.TransactionType;

public record CreateTransactionRequest(String product, TransactionType type, double amount) {
}
