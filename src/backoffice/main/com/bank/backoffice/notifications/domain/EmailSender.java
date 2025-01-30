package com.bank.backoffice.notifications.domain;

public interface EmailSender {

    void send(Email email);
}
