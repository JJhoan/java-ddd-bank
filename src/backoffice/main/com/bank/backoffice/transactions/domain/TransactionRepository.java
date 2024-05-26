package com.bank.backoffice.transactions.domain;

import java.util.Optional;

public interface TransactionRepository {

    void save(Transaction transaction);

    Optional<Transaction> search(TransactionId transactionId);
}
