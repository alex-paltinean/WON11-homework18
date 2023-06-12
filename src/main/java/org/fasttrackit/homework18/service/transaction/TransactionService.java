package org.fasttrackit.homework18.service.transaction;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.homework18.model.transaction.Transaction;
import org.fasttrackit.homework18.model.transaction.TransactionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.fasttrackit.homework18.model.transaction.TransactionType.BUY;
import static org.fasttrackit.homework18.model.transaction.TransactionType.SELL;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private long currentId = 0;
    private final List<Transaction> transactions = new ArrayList<>();
    private final TransactionRepository transactionRepository;

    public List<Transaction> getAll(String product, TransactionType type, Double minAmount, Double maxAmount) {
        Stream<Transaction> stream = transactionRepository.findAll().stream();
        if (product != null) {
            stream = stream.filter(transaction -> transaction.getProduct().equals(product));
        }
        if (type != null) {
            stream = stream.filter(transaction -> transaction.getType() == type);
        }
        if (minAmount != null) {
            stream = stream.filter(transaction -> transaction.getAmount() >= minAmount);
        }
        if (maxAmount != null) {
            stream = stream.filter(transaction -> transaction.getAmount() <= maxAmount);
        }
        return stream.toList();
    }

    public Transaction getById(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction add(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction add(double amount, String product, TransactionType type) {
        Transaction transaction = new Transaction(currentId++, product, type, amount);
        return transactionRepository.save(transaction);
    }

    public Map<TransactionType, List<Transaction>> getReportByType() {
        Map<TransactionType, List<Transaction>> report = new HashMap<>();
        List<Transaction> transactionList = transactionRepository.findAll();
        report.put(SELL, transactionList.stream().filter(transaction -> transaction.getType() == SELL).toList());
        report.put(BUY, transactionList.stream().filter(transaction -> transaction.getType() == BUY).toList());
        return report;
    }
}
