package com.bank.backoffice.accounts.application.withdraw_money;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.shared.domain.bus.command.Command;
import com.bank.shared.domain.bus.command.CommandHandler;

public final class WithdrawMoneyCommandHandler implements CommandHandler<WithdrawMoneyCommand> {

    private final MoneyWithdrawal withdrawal;

    public WithdrawMoneyCommandHandler(MoneyWithdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }


    @Override
    public void handle(WithdrawMoneyCommand command) {
        withdrawal.withdraw(new AccountId(command.id()), AccountAmount.of(command.amount()));
    }
}
