package com.bank.shared.domain.transaction;

import com.bank.shared.domain.bus.event.DomainEvent;
import lombok.Value;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;

@Value
@Accessors(fluent = true)
public class TransactionCreatedDomainEvent extends DomainEvent {

    String sourceAccount;
    String targetAccount;
    Double amount;

    public TransactionCreatedDomainEvent() {
        super(null);

        this.sourceAccount = null;
        this.targetAccount = null;
        this.amount = null;
    }

    public TransactionCreatedDomainEvent(String aggregateId, String sourceAccount, String targetAccount, Double amount) {
        super(aggregateId);

        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    public TransactionCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String sourceAccount,
            String targetAccount,
            Double amount
    ) {
        super(aggregateId, eventId, occurredOn);

        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public String eventName() {
        return "transaction.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("sourceAccount", sourceAccount);
            put("targetAccount", targetAccount);
            put("amount", amount);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new TransactionCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("sourceAccount"),
                (String) body.get("targetAccount"),
                (Double) body.get("amount")
        );
    }
}
