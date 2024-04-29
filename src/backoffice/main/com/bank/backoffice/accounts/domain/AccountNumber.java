package com.bank.backoffice.accounts.domain;

import java.util.regex.Pattern;

public record AccountNumber(String value) {

    private static Pattern ACCOUNT_NUMBER_REGEX = Pattern.compile( "^\\d+$" );

    public AccountNumber(String value) {
        ensureValidAccountNumber(value);
        this.value = value;
    }

    private void ensureValidAccountNumber( String value ) {
        value.matches( "^\\d+$" );
    }

}
