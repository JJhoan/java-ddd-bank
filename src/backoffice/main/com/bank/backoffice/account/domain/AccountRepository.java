package com.bank.backoffice.account.domain;

import java.util.Optional;

public interface AccountRepository {
    void save(Account account);

    Optional<Account> search(AccountId id);

}
