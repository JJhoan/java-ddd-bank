package com.bank.backoffice.notifications.application.send_money_received_notification;

import com.bank.backoffice.notifications.application.send_money_transfer_notification.MoneyTransferNotificationSender;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.account.AccountAmountDepositedDomainEvent;
import com.bank.shared.domain.account.AccountSenderMoneyDomainEvent;
import com.bank.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Service
@DomainEventSubscriber({
        AccountAmountDepositedDomainEvent.class
})
public class SendMoneyReceivedNotificationOnMoneyDeposited {

    private final MoneyReceivedNotificationSender sender;

    public SendMoneyReceivedNotificationOnMoneyDeposited(MoneyReceivedNotificationSender sender) {
        this.sender = sender;
    }

    @Async
    @EventListener
    public void on(AccountSenderMoneyDomainEvent event) {
        sender.send(event.sourceAccountId(), event.targetAccountId(), event.amount());
    }
}
