package com.bank.backoffice.accounts.application.deposite_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountFinderDomain;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneyDepositor {

    private final AccountRepository repository;
    private final EventBus eventBus;
    private final AccountFinderDomain finderDomain;

    public MoneyDepositor(AccountRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.finderDomain = new AccountFinderDomain(repository);
    }

    public void deposit(AccountId sourceAccountId, AccountId targetAccountId, AccountAmount amount) {
        final var account = finderDomain.find(targetAccountId);

        account.deposit(amount, sourceAccountId);

        repository.save(account);
        eventBus.publish(account.pullDomainEvents());
    }
}
