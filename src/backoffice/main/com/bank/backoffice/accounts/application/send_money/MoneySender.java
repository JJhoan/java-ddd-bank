package com.bank.backoffice.accounts.application.send_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountFinderDomain;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;
import jakarta.transaction.Transactional;

@UseCase
public class MoneySender {

    private final AccountRepository repository;
    private final EventBus eventBus;
    private final AccountFinderDomain finder;

    public MoneySender(AccountRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.finder = new AccountFinderDomain(repository);
    }

    @Transactional
    public void send(AccountId sourceAccountId, AccountId targetAccountId, AccountAmount amount) {
        final var sourceAccount = finder.find(sourceAccountId);

        sourceAccount.send(amount, targetAccountId);

        repository.save(sourceAccount);
        eventBus.publish(sourceAccount.pullDomainEvents());
    }
}
