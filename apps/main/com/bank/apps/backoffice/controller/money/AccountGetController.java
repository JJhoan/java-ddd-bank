package com.bank.apps.backoffice.controller.money;

import com.bank.backoffice.account.application.AccountResponse;
import com.bank.backoffice.account.application.find.AccountFinder;
import com.bank.backoffice.account.domain.AccountId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AccountGetController {

    private final AccountFinder finder;

    public AccountGetController(AccountFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> find(@PathVariable String id) {
        final var accountResponse = finder.find(new AccountId(id));

        return ResponseEntity.ok(accountResponse);
    }
}
