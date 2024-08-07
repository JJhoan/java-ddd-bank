package com.bank.backoffice.accounts.application.withdraw_money;

import com.bank.shared.domain.bus.command.Command;

import java.math.BigDecimal;

public record WithdrawMoneyCommand(String id, BigDecimal amount) implements Command {
}
