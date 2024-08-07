package com.bank.backoffice.accounts.application.withdraw_money;

import com.bank.backoffice.accounts.domain.*;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
public final class MoneyWithdrawal {

    private final MoneyWithdrawalDomain withdrawalDomain;

    public MoneyWithdrawal(AccountRepository repository, EventBus eventBus
    ) {
        this.withdrawalDomain = new MoneyWithdrawalDomain(repository, eventBus);
    }

    public void withdraw(AccountId id, AccountAmount amount) {
        withdrawalDomain.withdraw(id, amount);
    }
}
