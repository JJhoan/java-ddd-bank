package com.bank.backoffice.transactions.application;

public record TransactionRequest(String id, String from, String to, Double amount) {
}
