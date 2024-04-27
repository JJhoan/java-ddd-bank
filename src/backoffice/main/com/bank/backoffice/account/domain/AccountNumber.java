package com.bank.backoffice.account.domain;

import lombok.Value;

import java.util.regex.Pattern;

public class AccountNumber {

    private static Pattern ACCOUNT_NUMBER_REGEX = Pattern.compile( "^\\d+$" );
    private String value;

    private AccountNumber(String value) {
        ensureValidAccountNumber(value);
        this.value = value;
    }

    private void ensureValidAccountNumber( String value ) {
        value.matches( "^\\d+$" );
    }

    public String value() {
        return value;
    }
}
