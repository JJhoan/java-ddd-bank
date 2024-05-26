package com.bank.shared.domain.account;


import com.bank.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccountAmountWithdrawnDomainEvent extends DomainEvent {

    private final BigDecimal amount;

    public AccountAmountWithdrawnDomainEvent(String aggregateId, BigDecimal amount) {
        super(aggregateId);
        this.amount = amount;
    }


    public AccountAmountWithdrawnDomainEvent() {
        super(null);

        this.amount = null;
    }

    public BigDecimal amount() {
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
