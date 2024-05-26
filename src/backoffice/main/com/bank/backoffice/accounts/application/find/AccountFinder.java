package com.bank.backoffice.accounts.application.find;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.backoffice.accounts.domain.AccountFinderDomain;
import com.bank.shared.domain.UseCase;

@UseCase
final class AccountFinder {

    private final AccountFinderDomain finder;

    public AccountFinder(AccountRepository repository) {
        this.finder = new AccountFinderDomain(repository);
    }

    public AccountResponse find(AccountId id) throws AccountNotExist {
        var account = finder.find(id);
        return AccountResponse.fromAggregate(account);
    }
}
