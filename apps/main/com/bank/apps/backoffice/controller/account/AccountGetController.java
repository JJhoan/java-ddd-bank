package com.bank.apps.backoffice.controller.account;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.application.find.AccountFinder;
import com.bank.backoffice.accounts.domain.AccountId;
import org.apache.naming.java.javaURLContextFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public final class AccountGetController {

    private final AccountFinder finder;

    public AccountGetController(AccountFinder finder) {
        this.finder = finder;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable String id) {
        final AccountResponse accountResponse = finder.find(new AccountId(id));
        return ResponseEntity.ok(accountResponse);
    }
}
