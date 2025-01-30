package com.bank.backoffice.notifications.infrastructure.email.sendgrid;

import com.bank.shared.infrastructure.config.Parameter;
import com.bank.shared.infrastructure.config.ParameterNotExist;
import com.mailersend.sdk.MailerSend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackofficeMailerSenderConfiguration {
    private final Parameter config;

    public BackofficeMailerSenderConfiguration(Parameter config) {
        this.config = config;
    }

    @Bean
    public MailerSend dataSource() throws ParameterNotExist {
        var mailerSend = new MailerSend();
        mailerSend.setToken(config.get("BACKOFFICE_SENDGRID_API_KEY"));

        return mailerSend;
    }
}
