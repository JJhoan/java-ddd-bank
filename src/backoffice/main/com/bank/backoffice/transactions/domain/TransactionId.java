package com.bank.backoffice.transactions.domain;

import com.bank.shared.domain.Identifier;

import java.util.UUID;

public class TransactionId extends Identifier {
    public TransactionId(String value) {
        super(value);
    }

    public TransactionId(UUID value) {
        super(value.toString());
    }

    public TransactionId() {
    }

}
