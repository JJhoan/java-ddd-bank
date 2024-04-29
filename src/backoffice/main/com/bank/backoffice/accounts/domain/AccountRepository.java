package com.bank.backoffice.accounts.domain;

import java.util.Optional;

public interface AccountRepository {
    void save(Account account);

    Optional<Account> search(AccountId id);

}
