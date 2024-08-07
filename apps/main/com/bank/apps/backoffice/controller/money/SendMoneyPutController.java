package com.bank.apps.backoffice.controller.money;

import com.bank.backoffice.accounts.application.send_money.SendMoneyCommand;
import com.bank.backoffice.accounts.domain.AccountInsufficientFunds;
import com.bank.backoffice.accounts.domain.AccountNotExist;
import com.bank.shared.domain.DomainError;
import com.bank.shared.domain.bus.command.CommandBus;
import com.bank.shared.domain.bus.query.QueryBus;
import com.bank.shared.infrastructure.spring.ApiController;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SendMoneyPutController extends ApiController {

    public SendMoneyPutController(
            QueryBus queryBus,
            CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping("/send")
    public void sendMoney(@RequestBody SendMoneyResponse sendMoneyResponse) {
        dispatch(new SendMoneyCommand(sendMoneyResponse.from(), sendMoneyResponse.to(), sendMoneyResponse.money()));
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Maps.newHashMap(Map.of(
                AccountNotExist.class, HttpStatus.NOT_FOUND,
                AccountInsufficientFunds.class, HttpStatus.BAD_REQUEST
        ));
    }

    public record SendMoneyResponse(String from, String to, BigDecimal money) {
    }
}
