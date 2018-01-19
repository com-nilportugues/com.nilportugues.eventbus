package com.nilportugues.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class EventSubscriber {

    private static final Logger log = LoggerFactory.getLogger(EventSubscriber.class);
    private final Map<String, List<String>> events;
    private final BeanProvider provider;
    private final ClassResolverImpl resolver;

    public EventSubscriber(final BeanProvider provider, final ClassResolverImpl resolver) {
        this.events = new HashMap<>();
        this.provider = provider;
        this.resolver = resolver;
    }

    public void subscribe(final Class<?> event, final String handler) {
        CompletableFuture.runAsync(() -> {
            final String eventName = resolver.get(event);

            if (!events.containsKey(eventName)) {
                events.put(eventName, new ArrayList<>());
            }

            events.get(eventName).add(handler);
            log.info("Events registered for " + eventName);
        });
    }

    public List<EventHandler> get(final String eventName) {
        final List<String> eventHandlerNames = events.get(eventName);
        final List<EventHandler> instances = new ArrayList<>();
        eventHandlerNames.forEach(handlerName -> instances.add((EventHandler) provider.get(handlerName)));

        return instances;
    }
}
