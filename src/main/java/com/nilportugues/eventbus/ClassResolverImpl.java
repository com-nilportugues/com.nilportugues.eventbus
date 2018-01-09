package com.nilportugues.eventbus;

public class ClassResolverImpl implements ClassResolver {

    public String get(final Object object) {
        if (object instanceof Class<?>) {
            return ((Class<?>) object).getCanonicalName();
        }

        return object.getClass().getCanonicalName();
    }
}
