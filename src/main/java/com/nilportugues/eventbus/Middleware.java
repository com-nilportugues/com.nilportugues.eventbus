package com.nilportugues.eventbus;

import java.util.concurrent.CompletableFuture;

public interface Middleware {
    CompletableFuture execute(final Object object);
}
