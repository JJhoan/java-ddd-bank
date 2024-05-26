package com.bank.backoffice.transactions.domain;

import com.bank.shared.domain.AggregateRoot;
import com.bank.shared.domain.transaction.TransactionCreatedDomainEvent;

import java.util.Objects;

public final class Transaction extends AggregateRoot {

    private final TransactionId        id;
    private final TransactionAccountId from;
    private final TransactionAccountId to;
    private final TransactionAmount    amount;

    public Transaction(TransactionId id, TransactionAccountId from, TransactionAccountId to, TransactionAmount amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    private Transaction() {
        id = null;
        from = null;
        to = null;
        amount = null;
    }

    public TransactionId id() {
        return id;
    }

    public TransactionAccountId from() {
        return from;
    }

    public TransactionAccountId to() {
        return to;
    }

    public TransactionAmount amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, amount);
    }

    public static Transaction create(
            TransactionId id, TransactionAccountId from, TransactionAccountId to, TransactionAmount amount
    ) {
        final var transaction = new Transaction(id, from, to, amount);

        transaction.record(new TransactionCreatedDomainEvent(id.value(), from.value(), to.value(), amount.value().doubleValue()));

        return transaction;
    }
}
