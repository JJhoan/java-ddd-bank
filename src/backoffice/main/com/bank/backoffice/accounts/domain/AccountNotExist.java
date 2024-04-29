package com.bank.backoffice.accounts.domain;

import com.bank.shared.domain.DomainError;

public class AccountNotExist extends DomainError {

    public AccountNotExist(AccountId id) {
        super("course_not_exist", String.format("The account <%s> doesn't exist", id.value()));
    }
}
