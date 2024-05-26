package com.bank.backoffice.accounts.domain;

public final class AccountFinderDomain {

    private final AccountRepository repository;

    public AccountFinderDomain(AccountRepository repository) {
        this.repository = repository;
    }

    public Account find(AccountId id) {
        return repository.search(id)
                .orElseThrow(() -> new AccountNotExist(id));
    }
}
