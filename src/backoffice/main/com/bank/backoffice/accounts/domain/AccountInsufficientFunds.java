package com.bank.backoffice.accounts.domain;

import com.bank.shared.domain.DomainError;

public class AccountInsufficientFunds extends DomainError {
    public AccountInsufficientFunds(AccountNumber number) {
        super("account_insufficient_funds", String.format("Account <%s> doesn't have sufficient funds", number));
    }
}
