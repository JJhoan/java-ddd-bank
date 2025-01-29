package com.bank.backoffice.transactions.application.create;

import com.bank.backoffice.transactions.domain.TransactionAccountId;
import com.bank.backoffice.transactions.domain.TransactionAmount;
import com.bank.backoffice.transactions.domain.TransactionId;
import com.bank.shared.domain.bus.command.Command;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionCommand(TransactionId id,
                                       TransactionAccountId sourceAccount,
                                       TransactionAccountId targetAccount,
                                       TransactionAmount amount) implements Command {

    public static CreateTransactionCommand withId(
            String sourceAccountString,
            String targetAccountString,
            Double amountDouble) {

        TransactionId        id                = new TransactionId(UUID.randomUUID());
        TransactionAccountId sourceAccount     = new TransactionAccountId(sourceAccountString);
        TransactionAccountId targetAccount     = new TransactionAccountId(targetAccountString);
        TransactionAmount    transactionAmount = new TransactionAmount(BigDecimal.valueOf(amountDouble));

        return new CreateTransactionCommand(id, sourceAccount, targetAccount, transactionAmount);
    }

}
