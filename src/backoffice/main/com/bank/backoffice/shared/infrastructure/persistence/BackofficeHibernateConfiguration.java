package com.bank.backoffice.shared.infrastructure.persistence;

import com.bank.shared.infrastructure.config.Parameter;
import com.bank.shared.infrastructure.config.ParameterNotExist;
import com.bank.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class BackofficeHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "backoffice";

    public BackofficeHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config = config;
    }

    @Bean("backoffice-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("backoffice-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("backoffice-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
                config.get("BACKOFFICE_DATABASE_HOST"),
                config.getInt("BACKOFFICE_DATABASE_PORT"),
                config.get("BACKOFFICE_DATABASE_NAME"),
                config.get("BACKOFFICE_DATABASE_USER"),
                config.get("BACKOFFICE_DATABASE_PASSWORD")
        );
    }
}
