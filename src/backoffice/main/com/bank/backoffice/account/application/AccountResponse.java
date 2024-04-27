package com.bank.backoffice.account.application;

import com.bank.backoffice.account.domain.Account;

public class AccountResponse {

    private final String id;
    private final String number;

    private final Double amount;

    private AccountResponse(String id, String number, Double amount) {
        this.id = id;
        this.number = number;
        this.amount = amount;
    }

    public static AccountResponse fromAggregate( Account account) {
        return new AccountResponse( account.id().value(), account.number().value(), account.amount().value() );
    }
}
