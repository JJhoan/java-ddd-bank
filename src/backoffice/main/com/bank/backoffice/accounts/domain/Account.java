package com.bank.backoffice.accounts.domain;

import java.util.Objects;

public final class Account {

    private final AccountId     id;
    private final AccountNumber number;
    private final AccountAmount amount;

    public Account(AccountId id, AccountNumber number, AccountAmount amount) {
        this.id = id;
        this.number = number;
        this.amount = amount;
    }

    private Account() {
        id = null;
        number = null;
        amount = null;
    }

    public AccountId id() {
        return id;
    }

    public AccountNumber number() {
        return number;
    }

    public AccountAmount amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(number, account.number) &&
                Objects.equals(amount, account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, amount);
    }
}
