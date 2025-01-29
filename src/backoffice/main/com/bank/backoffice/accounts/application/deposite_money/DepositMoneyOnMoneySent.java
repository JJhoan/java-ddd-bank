package com.bank.backoffice.accounts.application.deposite_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountSenderMoneyDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;

@Service
@DomainEventSubscriber({
        AccountSenderMoneyDomainEvent.class,
})
public class DepositMoneyOnMoneySent {

    private final MoneyDepositor depositor;

    public DepositMoneyOnMoneySent(MoneyDepositor depositor) {
        this.depositor = depositor;
    }

    @Async
    @EventListener
    public void on(AccountSenderMoneyDomainEvent event) {
        var targetAccount = new AccountId(event.targetAccountId());
        var sourceAccount = new AccountId(event.sourceAccountId());
        var amount = new AccountAmount(BigDecimal.valueOf(event.amount()));

        depositor.deposit(sourceAccount, targetAccount, amount);
    }
}
