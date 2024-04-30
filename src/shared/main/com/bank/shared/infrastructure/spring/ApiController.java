package com.bank.shared.infrastructure.spring;

import com.bank.shared.domain.DomainError;
import com.bank.shared.domain.bus.command.Command;
import com.bank.shared.domain.bus.command.CommandBus;
import com.bank.shared.domain.bus.command.CommandHandlerExecutionError;
import com.bank.shared.domain.bus.query.Query;
import com.bank.shared.domain.bus.query.QueryBus;
import com.bank.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class ApiController {
    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
