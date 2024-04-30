package com.bank.backoffice.accounts.application;

import com.bank.backoffice.accounts.domain.Account;
import com.bank.shared.domain.bus.query.Response;


public record AccountResponse(String id, String number, Double amount) implements Response {
    public static AccountResponse fromAggregate(Account account) {
        return new AccountResponse( account.id().value(), account.number().value(), account.amount().value() );
    }
}
