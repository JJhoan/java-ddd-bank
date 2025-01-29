package com.bank.shared.domain.account;


import com.bank.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;


public class AccountSenderMoneyDomainEvent extends DomainEvent {

    private final String sourceAccountId;
    private final String targetAccountId;
    private final Double amount;

    public AccountSenderMoneyDomainEvent(String aggregateId, String sourceAccountId, String targetAccountId, Double amount) {
        super(aggregateId);
        this.amount = amount;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
    }


    public AccountSenderMoneyDomainEvent() {
        super(null);

        this.amount = null;
        this.sourceAccountId = null;
        this.targetAccountId = null;
    }

    public Double amount() {
        return amount;
    }

    public String sourceAccountId() {
        return sourceAccountId;
    }

    public String targetAccountId() {
        return targetAccountId;
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