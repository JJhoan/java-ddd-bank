package com.bank.backoffice.notifications.application.send_money_received_notification;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.application.find.FindAccountQuery;
import com.bank.backoffice.notifications.domain.Email;
import com.bank.backoffice.notifications.domain.EmailSender;
import com.bank.backoffice.notifications.domain.MoneyReceivedNotification;
import com.bank.shared.domain.UseCase;
import com.bank.shared.domain.bus.event.EventBus;
import com.bank.shared.domain.bus.query.QueryBus;

@UseCase
public final class MoneyReceivedNotificationSender {

    private final EventBus bus;
    private final EmailSender sender;
    private final QueryBus queryBus;

    public MoneyReceivedNotificationSender(EventBus bus, EmailSender sender, QueryBus queryBus) {
        this.bus = bus;
        this.sender = sender;
        this.queryBus = queryBus;
    }

    public void send(String accountIdFrom, String accountIdTo, Double amount) {
        final AccountResponse accountFrom = queryBus.ask(new FindAccountQuery(accountIdFrom));
        final AccountResponse accountTo = queryBus.ask(new FindAccountQuery(accountIdTo));

        final Email email = MoneyReceivedNotification.send(accountFrom.id(), accountFrom.number(), amount, accountTo.email());

        System.out.println(email);
        sender.send(email);

        bus.publish(email.pullDomainEvents());
    }

}
