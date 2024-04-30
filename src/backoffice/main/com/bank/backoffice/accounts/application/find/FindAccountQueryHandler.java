package com.bank.backoffice.accounts.application.find;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.bus.query.QueryHandler;

@Service
public class FindAccountQueryHandler implements QueryHandler<FindAccountQuery, AccountResponse> {

    private final AccountFinder finder;

    public FindAccountQueryHandler(AccountFinder finder) {
        this.finder = finder;
    }

    @Override
    public AccountResponse handle(FindAccountQuery query) throws AccountNotExist {
        return finder.find(new AccountId(query.id()));
    }
}
