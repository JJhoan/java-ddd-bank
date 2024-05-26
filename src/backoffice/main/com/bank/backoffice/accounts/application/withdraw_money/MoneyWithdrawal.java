package com.bank.backoffice.accounts.application.withdraw_money;

import com.bank.backoffice.accounts.domain.*;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneyWithdrawal {

    private final AccountRepository repository;
    private final EventBus eventBus;
    private final AccountFinderDomain finder;

    public MoneyWithdrawal(AccountRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.finder = new AccountFinderDomain(repository);
    }

    public void withdraw(AccountId id, AccountAmount amount) {
        final var account = finder.find(id);

        account.withdraw(amount);

        repository.save(account);
        eventBus.publish(account.pullDomainEvents());

        System.out.println(String.format("Account withdraw -> %s", account));
    }
}
