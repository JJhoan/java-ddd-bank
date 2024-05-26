package com.bank.apps.backoffice.controller.transactions;

import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.backoffice.transactions.application.TransactionRequest;
import com.bank.backoffice.transactions.application.create.CreateTransactionCommand;
import com.bank.shared.domain.DomainError;
import com.bank.shared.domain.bus.command.CommandBus;
import com.bank.shared.domain.bus.query.QueryBus;
import com.bank.shared.infrastructure.spring.ApiController;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/transactions")
public final class TransactionPostController extends ApiController {

    public TransactionPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TransactionRequest transaction) {
        dispatch(new CreateTransactionCommand(transaction.id(), transaction.from(), transaction.to(), transaction.amount()));
    }*/

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Maps.newHashMap(Map.of(AccountNotExist.class, HttpStatus.NOT_FOUND));
    }
}
