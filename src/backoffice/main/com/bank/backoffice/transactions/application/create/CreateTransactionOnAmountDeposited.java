package com.bank.backoffice.transactions.application.create;


import com.bank.backoffice.transactions.domain.TransactionAccountId;
import com.bank.backoffice.transactions.domain.TransactionAmount;
import com.bank.backoffice.transactions.domain.TransactionId;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountAmountDepositedDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import com.bank.shared.domain.transaction.TransactionCreatedDomainEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;
import java.util.UUID;

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
