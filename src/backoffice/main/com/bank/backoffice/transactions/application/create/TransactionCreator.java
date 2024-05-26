package com.bank.backoffice.transactions.application.create;

import com.bank.backoffice.transactions.domain.*;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;

@UseCase
final class TransactionCreator {

    private final TransactionRepository repository;
    private final EventBus              eventBus;

    private TransactionCreator(TransactionRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(CreateTransactionCommand command) {

        Transaction transaction = Transaction.create(
                command.id(),
                command.sourceAccount(),
                command.targetAccount(),
                command.amount());

        repository.save(transaction);

        eventBus.publish(transaction.pullDomainEvents());
    }
}
