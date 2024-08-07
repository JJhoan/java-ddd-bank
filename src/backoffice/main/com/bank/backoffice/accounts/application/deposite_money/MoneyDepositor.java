package com.bank.backoffice.accounts.application.deposite_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountFinderDomain;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.backoffice.accounts.domain.MoneyDepositorDomain;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneyDepositor {

    private final MoneyDepositorDomain depositorDomain;

    public MoneyDepositor(AccountRepository repository, EventBus eventBus) {
        this.depositorDomain = new MoneyDepositorDomain(repository, eventBus);
    }

    public void deposit(AccountId id, AccountAmount amount) {
        depositorDomain.deposit(id, amount);
    }
}
