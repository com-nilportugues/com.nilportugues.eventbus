package com.nilportugues.eventbus;

import java.util.concurrent.CompletableFuture;

public interface EventHandler<E> {

    CompletableFuture<Void> handle(final E event);
}
