package com.nilportugues.eventbus;

public interface BeanProvider<T> {
    T get(final String beanName);
}
