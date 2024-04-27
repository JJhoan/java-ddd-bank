package com.bank.apps.backoffice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import com.bank.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        value = {"com.bank.shared", "com.bank.backoffice", "com.bank.apps.backoffice"}
)
public class BackofficeBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>();
    }
}
