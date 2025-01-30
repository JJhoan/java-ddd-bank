package com.bank.backoffice.notifications.application.send_money_transfer_notification;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.application.find.FindAccountQuery;
import com.bank.backoffice.notifications.domain.Email;
import com.bank.backoffice.notifications.domain.EmailSender;
import com.bank.backoffice.notifications.domain.MoneyTransferNotification;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;
import com.bank.shared.domain.bus.query.QueryBus;

@UseCase
public final class MoneyTransferNotificationSender {

    private final EventBus bus;
    private final EmailSender sender;
    private final QueryBus queryBus;

    public MoneyTransferNotificationSender(EventBus bus, EmailSender sender, QueryBus queryBus) {
        this.bus = bus;
        this.sender = sender;
        this.queryBus = queryBus;
    }

    public void send(String accountIdFrom, String accountIdTo, Double amount) {
        final AccountResponse accountFrom = queryBus.ask(new FindAccountQuery(accountIdFrom));
        final AccountResponse accountTo = queryBus.ask(new FindAccountQuery(accountIdTo));

        final Email email = MoneyTransferNotification.send(accountFrom.id(), accountTo.number(), amount, accountFrom.email());

        sender.send(email);

        bus.publish(email.pullDomainEvents());
    }

}
