package com.bank.apps.backoffice.config;

import com.bank.apps.backoffice.middleware.BasicHttpAuthMiddleware;
import com.bank.shared.domain.bus.command.CommandBus;
import com.bank.shared.infrastructure.spring.ApiExceptionMiddleware;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class BackofficeBackendServerConfiguration {
    private final CommandBus bus;

    private final RequestMappingHandlerMapping mapping;

    public BackofficeBackendServerConfiguration(CommandBus bus, RequestMappingHandlerMapping mapping) {
        this.bus = bus;
        this.mapping = mapping;
    }

    @Bean
    public FilterRegistrationBean<ApiExceptionMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiExceptionMiddleware(mapping));
        //registrationBean.setFilter(new BasicHttpAuthMiddleware(bus));
        //registrationBean.addUrlPatterns("/health-check");
        //registrationBean.addUrlPatterns("/api/accounts/*");

        return registrationBean;
    }
}
