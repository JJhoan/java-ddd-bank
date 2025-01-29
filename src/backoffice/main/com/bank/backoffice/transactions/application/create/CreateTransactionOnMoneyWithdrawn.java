package com.bank.backoffice.transactions.application.create;

import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountAmountWithdrawnDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({AccountAmountWithdrawnDomainEvent.class})
public class CreateTransactionOnMoneyWithdrawn {

    private final TransactionCreator creator;

    public CreateTransactionOnMoneyWithdrawn(TransactionCreator creator) {
        this.creator = creator;
    }

    /*@Async
    @EventListener
    public void on(TransactionCreatedDomainEvent event) {

        CreateTransactionCommand command = CreateTransactionCommand.withId(
                event.sourceAccount(),
                event.targetAccount(),
                event.amount());

        creator.create(command);
    }*/
}
