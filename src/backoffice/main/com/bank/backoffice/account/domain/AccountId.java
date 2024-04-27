package com.bank.backoffice.account.domain;

import com.bank.shared.domain.Identifier;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class AccountId extends Identifier {
    public AccountId( String value ) {
        super( value );
    }

}
