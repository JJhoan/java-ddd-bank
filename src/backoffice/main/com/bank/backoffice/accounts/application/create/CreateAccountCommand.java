package com.bank.backoffice.accounts.application.create;

import com.bank.shared.domain.bus.command.Command;

public record CreateAccountCommand(String id, String number, Double amount) implements Command {
}
