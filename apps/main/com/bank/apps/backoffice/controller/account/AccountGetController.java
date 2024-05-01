package com.bank.apps.backoffice.controller.account;

import com.bank.backoffice.accounts.application.AccountResponse;
import com.bank.backoffice.accounts.application.find.FindAccountQuery;
import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.shared.domain.DomainError;
import com.bank.shared.domain.bus.command.CommandBus;
import com.bank.shared.domain.bus.query.QueryBus;
import com.bank.shared.infrastructure.spring.ApiController;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public final class AccountGetController extends ApiController {

    public AccountGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable String id) {
        final AccountResponse accountResponse = ask(new FindAccountQuery(id));
        return ResponseEntity.ok(accountResponse);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Maps.newHashMap(Map.of(AccountNotExist.class, HttpStatus.NOT_FOUND));
    }
}
