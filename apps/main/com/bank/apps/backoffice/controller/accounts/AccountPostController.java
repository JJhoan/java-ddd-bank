package com.bank.apps.backoffice.controller.accounts;

import com.bank.backoffice.accounts.application.create.CreateAccountCommand;
import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.shared.domain.DomainError;
import com.bank.shared.domain.bus.command.CommandBus;
import com.bank.shared.domain.bus.query.QueryBus;
import com.bank.shared.infrastructure.spring.ApiController;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public final class AccountPostController extends ApiController {

    public AccountPostController(QueryBus query, CommandBus command) {
        super(query, command);
    }

    @PostMapping
    public void index(@RequestBody CreateAccountRequest request) {
        dispatch(new CreateAccountCommand(request.id(), request.number(), request.amount()));
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Maps.newHashMap(Map.of(AccountNotExist.class, HttpStatus.NOT_FOUND));
    }

    public record CreateAccountRequest(String id, String number, Double amount) {}
}
//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
