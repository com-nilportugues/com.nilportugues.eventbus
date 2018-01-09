package com.nilportugues.eventbus;

public class LocalEventPublisher implements EventPublisher {

    private final EventHandlerDispatcher dispatcher;

    public LocalEventPublisher(final EventHandlerDispatcherImpl dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void publish(Object event) {
        dispatcher.dispatch(event);
    }
}
