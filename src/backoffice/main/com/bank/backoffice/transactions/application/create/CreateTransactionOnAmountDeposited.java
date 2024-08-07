package com.bank.backoffice.transactions.application.create;

import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountAmountDepositedDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import com.bank.shared.domain.transaction.TransactionCreatedDomainEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Service
@DomainEventSubscriber({AccountAmountDepositedDomainEvent.class})
public class CreateTransactionOnAmountDeposited {

    private final TransactionCreator creator;

    public CreateTransactionOnAmountDeposited(TransactionCreator creator) {
        this.creator = creator;
    }

    @Async
    @EventListener
    public void on(TransactionCreatedDomainEvent event) {

        CreateTransactionCommand command = CreateTransactionCommand.withId(
                event.sourceAccount(),
                event.targetAccount(),
                event.amount());

        creator.create(command);
    }
}
