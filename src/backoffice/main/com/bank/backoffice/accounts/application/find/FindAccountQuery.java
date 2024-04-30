package com.bank.backoffice.accounts.application.find;

import com.bank.shared.domain.bus.query.Query;

public record FindAccountQuery(String id) implements Query {

}
