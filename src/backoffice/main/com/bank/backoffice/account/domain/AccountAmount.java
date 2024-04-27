package com.bank.backoffice.account.domain;

public class AccountAmount {

    private Double value;

    private AccountAmount( Double value ) {
        this.value = value;
    }

    public Double value() {
        return value;
    }
}
