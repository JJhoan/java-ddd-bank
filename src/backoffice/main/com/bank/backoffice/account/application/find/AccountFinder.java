package com.bank.backoffice.account.application.find;

import com.bank.backoffice.account.application.AccountResponse;
import com.bank.backoffice.account.domain.AccountId;
import com.bank.backoffice.account.domain.AccountNotExist;
import com.bank.backoffice.account.domain.AccountRepository;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.UseCase;

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
