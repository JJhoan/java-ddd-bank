package com.bank.backoffice.accounts.application;

import com.bank.backoffice.accounts.domain.Account;
import lombok.Getter;
import lombok.Setter;

public record AccountResponse(String id, String number, Double amount) {
    public static AccountResponse fromAggregate(Account account) {
        return new AccountResponse( account.id().value(), account.number().value(), account.amount().value() );
    }
}
