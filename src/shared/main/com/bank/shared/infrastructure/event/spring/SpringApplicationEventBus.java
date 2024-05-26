package com.bank.shared.infrastructure.event.spring;

import com.bank.shared.domain.Service;
import com.bank.shared.domain.bus.event.DomainEvent;
import com.bank.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.scheduling.annotation.Async;


import java.util.List;

@Primary
@Service
public class SpringApplicationEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        publisher.publishEvent(event);
    }
}
