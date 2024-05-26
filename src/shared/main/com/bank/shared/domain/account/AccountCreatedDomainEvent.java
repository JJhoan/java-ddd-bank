package com.bank.shared.domain.account;


import com.bank.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccountCreatedDomainEvent extends DomainEvent {

    private final String     number;
    private final BigDecimal amount;

    public AccountCreatedDomainEvent(String aggregateId, String number, BigDecimal amount) {
        super(aggregateId);
        this.number = number;
        this.amount = amount;
    }


    public AccountCreatedDomainEvent() {
        super(null);

        this.number = null;
        this.amount = null;
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
