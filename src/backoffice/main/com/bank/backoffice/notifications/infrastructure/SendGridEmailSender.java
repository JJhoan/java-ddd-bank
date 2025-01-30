package com.bank.backoffice.notifications.infrastructure;

import com.bank.backoffice.notifications.domain.Email;
import com.bank.backoffice.notifications.domain.EmailSender;
import com.bank.shared.domain.Service;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.exceptions.MailerSendException;

@Service
public class SendGridEmailSender implements EmailSender {

    private final MailerSend mailerSend;

    public SendGridEmailSender(MailerSend mailerSend) {
        this.mailerSend = mailerSend;
    }


    @Override
    public void send(Email email) {
        com.mailersend.sdk.emails.Email  mailSenderEmail = new  com.mailersend.sdk.emails.Email();

        mailSenderEmail.setFrom("name", email.from());
        mailSenderEmail.addRecipient("name", email.to());
        mailSenderEmail.setSubject(email.subject());
        mailSenderEmail.setHtml(String.format(email.body()));

        sendEmail(mailSenderEmail);
    }

    private void sendEmail(com.mailersend.sdk.emails.Email  email) {
        try {
            MailerSendResponse response = mailerSend.emails().send(email);
        } catch (MailerSendException e) {
            e.printStackTrace();
        }
    }
}
