package com.bank.backoffice.accounts.domain;

public class AccountAmount {

    private Double value;

    private AccountAmount( Double value ) {

    }
    private AccountAmount( ) {
    }

    public Double value() {
        return value;
    }
}
