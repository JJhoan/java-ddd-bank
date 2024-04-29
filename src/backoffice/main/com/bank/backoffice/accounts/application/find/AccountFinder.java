package com.bank.backoffice.accounts.application.find;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.shared.domain.Service;

@Service
public final class AccountFinder {

    private final AccountRepository repository;

    public AccountFinder(AccountRepository repository) {
        this.repository = repository;
    }

    public AccountResponse find(AccountId id) throws AccountNotExist {
        return repository.search(id)
                .map(AccountResponse::fromAggregate)
                .orElseThrow(() -> new AccountNotExist(id));
    }
}
