package com.bank.backoffice.accounts.application.create;

import com.bank.backoffice.accounts.domain.AccountAmount;
import com.bank.backoffice.accounts.domain.AccountEmail;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountNumber;
import com.bank.shared.domain.Service;
import com.bank.shared.domain.bus.command.CommandHandler;

@Service
public class CreateAccountCommandHandler implements CommandHandler<CreateAccountCommand> {

    private final AccountCreator creator;

    public CreateAccountCommandHandler(AccountCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateAccountCommand command) {
        creator.create(
                new AccountId(command.id()),
                new AccountNumber(command.number()),
                AccountAmount.of(command.amount()),
                new AccountEmail(command.email())
        );
    }
}
