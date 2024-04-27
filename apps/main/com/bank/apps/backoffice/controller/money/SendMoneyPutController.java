package com.bank.apps.backoffice.controller.money;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class SendMoneyPutController {

    @PutMapping("/send")
    public void sendMoney(@RequestBody SendMoneyResponse sendMoneyResponse) {

    }

    private static class SendMoneyResponse {
        private final Integer from;
        private final Integer to;
        private final BigDecimal money;

        public SendMoneyResponse(Integer from, Integer to, BigDecimal money) {
            this.from = from;
            this.to = to;
            this.money = money;
        }

        public Integer getFrom() {
            return from;
        }

        public Integer getTo() {
            return from;
        }

        public Integer getMoney() {
            return from;
        }
    }
}
