package com.bank.backoffice.accounts.domain;

import java.math.BigDecimal;

public record AccountAmount(BigDecimal value) {

    public static AccountAmount of(Double value) {
        return of(BigDecimal.valueOf(value));
    }

    public static AccountAmount subtract(AccountAmount a, AccountAmount b) {
        return new AccountAmount(a.value.subtract(b.value));
    }

    public static AccountAmount add(AccountAmount a, AccountAmount b) {
        return new AccountAmount(a.value.add(b.value));
    }

    public static AccountAmount of(BigDecimal value) {
        ensureValueIsPositive(value);
        return new AccountAmount(value);
    }

    public static void ensureValueIsPositive(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
    }

    public AccountAmount add(AccountAmount amount) {
        return new AccountAmount(value.add(amount.value));
    }

    public boolean isGreaterThanOrEqualTo(AccountAmount amount) {
        return value.compareTo(amount.value) > 0;
    }

    public boolean isLessThan(AccountAmount amount) {
        return value.compareTo(amount.value) < 0;
    }

    public AccountAmount multiply(AccountAmount amount) {
        return new AccountAmount(value.multiply(amount.value()));
    }

    public boolean isPositiveOrZero() {
        return value.compareTo(BigDecimal.ZERO) >= 0;
    }
}
