package com.nilportugues.eventbus;

@SuppressWarnings("unchecked")
public class EventBus {

    private final EventPublisher publisher;

    public EventBus(final EventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Object event) {
        publisher.publish(event);
    }
}
