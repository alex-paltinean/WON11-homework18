package org.fasttrackit.homework18.controller.transaction;

import org.fasttrackit.homework18.model.transaction.Transaction;

import java.util.List;

public record ReportByTypeResponse(List<Transaction> SELL, List<Transaction> BUY) {

}
