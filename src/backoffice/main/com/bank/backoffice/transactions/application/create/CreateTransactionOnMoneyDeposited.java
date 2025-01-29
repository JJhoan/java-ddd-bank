package com.bank.backoffice.transactions.application.create;

import com.bank.backoffice.transactions.domain.TransactionAccountId;
import com.bank.backoffice.transactions.domain.TransactionAmount;
import com.bank.backoffice.transactions.domain.TransactionId;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountAmountDepositedDomainEvent;
import com.bank.shared.domain.account.AccountSenderMoneyDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;

@Service
@DomainEventSubscriber({
        AccountSenderMoneyDomainEvent.class,
        AccountAmountDepositedDomainEvent.class
})
public class CreateTransactionOnMoneyDeposited {

    private final TransactionCreator creator;

    public CreateTransactionOnMoneyDeposited(TransactionCreator creator) {
        this.creator = creator;
    }

    @Async
    @EventListener
    public void on(AccountSenderMoneyDomainEvent event) {

        TransactionId        id            = new TransactionId(UUID.randomUUID());
        TransactionAccountId sourceAccount = new TransactionAccountId(event.sourceAccountId());
        TransactionAccountId targetAccount = new TransactionAccountId(event.targetAccountId());
        TransactionAmount    amount        = TransactionAmount.negative(event.amount());

        CreateTransactionCommand command =
                new CreateTransactionCommand(
                        id,
                        sourceAccount,
                        targetAccount,
                        amount
                );

        creator.create(command);

    }

    @Async
    @EventListener
    public void on(AccountAmountDepositedDomainEvent event) {

        CreateTransactionCommand command = CreateTransactionCommand.withId(
                event.targetAccountId(),
                event.sourceAccountId(),
                event.amount());

        creator.create(command);
    }
}
