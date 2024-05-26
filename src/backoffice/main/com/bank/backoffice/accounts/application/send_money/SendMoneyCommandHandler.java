package com.bank.backoffice.accounts.application.send_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.bus.command.CommandHandler;

@Service
public final class SendMoneyCommandHandler implements CommandHandler<SendMoneyCommand> {

    private final MoneySender sender;

    private SendMoneyCommandHandler(MoneySender sender) {
        this.sender = sender;
    }

    @Override
    public void handle(SendMoneyCommand command) {
        AccountId     from   = new AccountId(command.from());
        AccountId     to     = new AccountId(command.to());
        AccountAmount amount = AccountAmount.of(command.amount());

        sender.send(from, to, amount);
    }
}
