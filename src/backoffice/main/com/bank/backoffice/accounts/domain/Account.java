package com.bank.backoffice.accounts.domain;

import com.bank.shared.domain.AggregateRoot;
import com.bank.shared.domain.account.AccountAmountDepositedDomainEvent;
import com.bank.shared.domain.account.AccountAmountWithdrawnDomainEvent;
import com.bank.shared.domain.account.AccountCreatedDomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.NonFinal;


@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false)
public class Account extends AggregateRoot {

    AccountId     id;
    AccountNumber number;
    @NonFinal AccountAmount amount;

    public static Account create(AccountId id, AccountNumber number, AccountAmount amount) {
        final Account account = new Account(id, number, amount);

        account.record(
                new AccountCreatedDomainEvent(
                        account.id().value(),
                        account.number().value(),
                        account.amount().value()
                )
        );

        return account;
    }

    public void withdraw(AccountAmount amount) {
        if (!mayWithdraw(amount)) {
            throw new AccountInsufficientFunds(number);
        }

        this.amount = AccountAmount.subtract(this.amount, amount);

        record(new AccountAmountWithdrawnDomainEvent(id.value(), amount.value()));
    }

    public void deposit(AccountAmount amount) {
        this.amount = AccountAmount.add(this.amount, amount);

        record(new AccountAmountDepositedDomainEvent(id.value(), amount.value()));
    }

    private boolean mayWithdraw(AccountAmount amount) {
        return AccountAmount.subtract(this.amount, amount).isPositiveOrZero();
    }

}
