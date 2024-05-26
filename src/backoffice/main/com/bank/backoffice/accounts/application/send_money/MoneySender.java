package com.bank.backoffice.accounts.application.send_money;

import com.bank.backoffice.accounts.domain.*;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneySender {

    private final EventBus            bus;
    private final AccountFinderDomain finder;

    private MoneySender(AccountRepository repository, EventBus bus) {
        this.bus = bus;
        this.finder = new AccountFinderDomain(repository);
    }

    public void send(AccountId sourceAccountId, AccountId targetAccountId, AccountAmount amount) {

        Account sourceAccount = finder.find(sourceAccountId);
        Account targetAccount = finder.find(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        bus.publish(sourceAccount.pullDomainEvents());
        bus.publish(targetAccount.pullDomainEvents());
    }
}
