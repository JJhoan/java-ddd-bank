package com.bank.backoffice.accounts.application.send_money;

import com.bank.shared.domain.bus.command.Command;

import java.math.BigDecimal;

public record SendMoneyCommand(String from, String to, BigDecimal amount) implements Command {
}
