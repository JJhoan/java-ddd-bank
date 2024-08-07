package com.bank.backoffice.accounts.domain;

import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneyDepositorDomain {

    private final AccountRepository   repository;
    private final EventBus            eventBus;
    private final AccountFinderDomain finder;

    public MoneyDepositorDomain(AccountRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.finder = new AccountFinderDomain(repository);
    }

    public void deposit(AccountId id, AccountAmount amount) {
        final var account = finder.find(id);

        account.deposit(amount);
        repository.save(account);

        eventBus.publish(account.pullDomainEvents());
    }
}
