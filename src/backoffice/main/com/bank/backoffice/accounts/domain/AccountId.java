package com.bank.backoffice.accounts.domain;

import com.bank.shared.domain.Identifier;
import lombok.NoArgsConstructor;

public final class AccountId extends Identifier {
    public AccountId( String value ) {
        super( value );
    }

    public AccountId(){}

}
