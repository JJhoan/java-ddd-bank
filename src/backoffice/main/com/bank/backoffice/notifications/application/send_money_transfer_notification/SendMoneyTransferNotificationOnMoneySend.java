package com.bank.backoffice.notifications.application.send_money_transfer_notification;

import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountSenderMoneyDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Service
@DomainEventSubscriber({
        AccountSenderMoneyDomainEvent.class
})
public class SendMoneyTransferNotificationOnMoneySend {

    private final MoneyTransferNotificationSender sender;

    public SendMoneyTransferNotificationOnMoneySend(MoneyTransferNotificationSender sender) {
        this.sender = sender;
    }

    @Async
    @EventListener
    public void on(AccountSenderMoneyDomainEvent event) {
        sender.send(event.sourceAccountId(), event.targetAccountId(), event.amount());
    }
}
