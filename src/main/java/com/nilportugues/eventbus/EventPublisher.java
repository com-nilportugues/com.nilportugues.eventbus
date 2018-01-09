package com.nilportugues.eventbus;

public interface EventPublisher<T> {
    void publish(T event);
}
