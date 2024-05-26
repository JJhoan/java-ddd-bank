package com.bank.backoffice.accounts.application.deposite_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountFinderDomain;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneyDepositor {

    private final AccountRepository   repository;
    private final EventBus            eventBus;
    private final AccountFinderDomain finder;

    public MoneyDepositor(AccountRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.finder = new AccountFinderDomain(repository);
    }

    public void deposit(AccountId id, AccountAmount amount) {
        final var account = finder.find(id);

        account.deposit(amount);
        repository.save(account);
        eventBus.publish(account.pullDomainEvents());

        System.out.println(String.format("Account Deposit -> %s", account));
    }
}
