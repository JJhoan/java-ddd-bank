package com.bank.backoffice.accounts.application.send_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.backoffice.accounts.domain.MoneyDepositorDomain;
import com.bank.backoffice.accounts.domain.MoneyWithdrawalDomain;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;
import jakarta.transaction.Transactional;

@UseCase
public final class MoneySender {

    private final MoneyWithdrawalDomain withdrawal;
    private final MoneyDepositorDomain  depositor;

    private MoneySender(AccountRepository repository, EventBus eventBus) {
        this.withdrawal = new MoneyWithdrawalDomain(repository, eventBus);
        this.depositor = new MoneyDepositorDomain(repository, eventBus);
    }

    @Transactional
    public void send(AccountId sourceAccountId, AccountId targetAccountId, AccountAmount amount) {
        withdrawal.withdraw(sourceAccountId, amount);
        depositor.deposit(targetAccountId, amount);
    }
}
