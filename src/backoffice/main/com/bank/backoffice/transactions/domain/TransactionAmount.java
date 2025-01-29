package com.bank.backoffice.transactions.domain;

import java.math.BigDecimal;

public record TransactionAmount(BigDecimal value) {

    public TransactionAmount(BigDecimal value) {
        this.value = value;
    }

    public static TransactionAmount from(Double value) {
        return new TransactionAmount(BigDecimal.valueOf(value));
    }

    public static TransactionAmount negative(Double value) {
        return new TransactionAmount(BigDecimal.valueOf(value).negate());
    }

    public TransactionAmount subtract(TransactionAmount amount) {
        value.subtract(amount.value);
        return this;
    }

    public TransactionAmount add(TransactionAmount amount) {
        value.add(amount.value());
        return this;
    }

    public boolean greaterThan(TransactionAmount amount) {
        return value.compareTo(amount.value()) > 0;
    }

    public boolean greaterThan(BigDecimal amount) {
        return value.compareTo(amount) > 0;
    }

    public boolean lessThan(TransactionAmount amount) {
        return value.compareTo(amount.value()) < 0;
    }

    public boolean lessThan(BigDecimal amount) {
        return value.compareTo(amount) < 0;
    }

    public TransactionAmount multiply(TransactionAmount amount) {
        return new TransactionAmount(value.multiply(amount.value()));
    }

    public TransactionAmount multiply(BigDecimal amount) {
        return new TransactionAmount(value.multiply(amount));
    }

    public boolean hasBalance(TransactionAmount amount) {
        return value.compareTo(amount.value()) >= 0;
    }
}
