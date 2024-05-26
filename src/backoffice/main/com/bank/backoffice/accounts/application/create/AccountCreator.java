package com.bank.backoffice.accounts.application.create;

import com.bank.backoffice.accounts.domain.*;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class AccountCreator {

    private final AccountRepository repository;
    private final EventBus bus;

    public AccountCreator(AccountRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public void create(AccountId id, AccountNumber number, AccountAmount amount) {
        final Account account = Account.create(id, number, amount);

        repository.save(account);
        bus.publish(account.pullDomainEvents());
    }
}
