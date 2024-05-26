package com.bank.backoffice.accounts.application.withdraw_money;


import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import com.bank.shared.domain.transaction.TransactionCreatedDomainEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Service
@DomainEventSubscriber({TransactionCreatedDomainEvent.class})
public class WithdrawMoneyOnTransactionCreated {

    private final MoneyWithdrawal withdrawal;

    public WithdrawMoneyOnTransactionCreated(MoneyWithdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }

    @EventListener
    @Async
    public void on(TransactionCreatedDomainEvent event) {
        withdrawal.withdraw(new AccountId(event.targetAccount()), AccountAmount.of(event.amount()));
    }
}
