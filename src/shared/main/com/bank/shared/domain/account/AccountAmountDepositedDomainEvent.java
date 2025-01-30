package com.bank.shared.domain.account;

import com.bank.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class AccountAmountDepositedDomainEvent extends DomainEvent {

    private final String sourceAccountId;
    private final String targetAccountId;
    private final Double amount;

    public AccountAmountDepositedDomainEvent(String aggregateId, String sourceAccountId, String targetAccountId, Double amount) {
        super(aggregateId);

        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }


    public AccountAmountDepositedDomainEvent() {
        super(null);

        this.sourceAccountId = null;
        this.targetAccountId = null;
        this.amount = null;
    }

   public String sourceAccountId() {
       return sourceAccountId;
   }

   public String targetAccountId() {
       return targetAccountId;
   }

    public Double amount() {
        return amount;
    }

    @Override
    public String eventName() {
        return null;
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return null;
    }
}
