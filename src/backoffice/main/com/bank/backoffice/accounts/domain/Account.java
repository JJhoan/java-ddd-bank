package com.bank.backoffice.accounts.domain;

import com.bank.shared.domain.AggregateRoot;
import com.bank.shared.domain.account.AccountAmountDepositedDomainEvent;
import com.bank.shared.domain.account.AccountAmountWithdrawnDomainEvent;
import com.bank.shared.domain.account.AccountCreatedDomainEvent;
import com.bank.shared.domain.account.AccountSenderMoneyDomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.NonFinal;


@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false)
public class Account extends AggregateRoot {

    AccountId id;
    AccountNumber number;
    @NonFinal
    AccountAmount amount;

    public Account() {
        this.id = null;
        this.number = null;
        this.amount = null;
    }

    public Account(AccountId id, AccountNumber number, AccountAmount amount) {
        this.id = id;
        this.number = number;
        this.amount = amount;
    }

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
        ensureCanWithdraw(amount);

        this.amount = AccountAmount.subtract(this.amount, amount);

        record(new AccountAmountWithdrawnDomainEvent(id.value(), amount.value()));
    }

    public void send(AccountAmount amount, AccountId target) {
        ensureCanWithdraw(amount);

        this.amount = AccountAmount.subtract(this.amount, amount);

        record(new AccountSenderMoneyDomainEvent(id.value(), this.id.value(), target.value(), amount.value().doubleValue()));
    }

    public void deposit(AccountAmount amount, AccountId sourceAccountId) {
        this.amount = AccountAmount.add(this.amount, amount);

        record(new AccountAmountDepositedDomainEvent(id.value(), sourceAccountId.value(), this.id.value(), amount.value().doubleValue()));
    }

    private void ensureCanWithdraw(AccountAmount amount) {
        if (AccountAmount.subtract(this.amount, amount).isPositiveOrZero()) {
            return;
        }

        throw new AccountInsufficientFunds(number);
    }
}