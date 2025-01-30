package com.bank.backoffice.accounts.domain;

public final class AccountEmail {
    private final String value;

    public AccountEmail() {
        this.value = null;
    }

    public AccountEmail(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
