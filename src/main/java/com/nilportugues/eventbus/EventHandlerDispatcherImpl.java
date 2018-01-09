package com.nilportugues.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Optional;

public class EventHandlerDispatcherImpl implements EventHandlerDispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(EventHandlerDispatcherImpl.class);
    private static final String LOG_MSG = "Handling event {} ...";
    private static final String EXCEPTION_MSG = "Could not find event handler for class: ";

    private final EventSubscriber subscriber;
    private final ClassResolverImpl resolver;

    public EventHandlerDispatcherImpl(EventSubscriber subscriber, ClassResolverImpl resolver) {
        this.subscriber = subscriber;
        this.resolver = resolver;
    }

    @SuppressWarnings("unchecked")
    public void dispatch(Object event) {
        final String eventName = resolver.get(event);

        try {
            final Optional optional = Optional.ofNullable(subscriber.get(eventName));

            if (!optional.isPresent()) {
                throw new RuntimeException(EXCEPTION_MSG + eventName);
            }

            final List<EventHandler> eventHandlers = (List<EventHandler>) optional.get();

            Flux.fromIterable(eventHandlers)
                    .doOnNext(eventHandler -> eventHandler.handle(event))
                    .publishOn(Schedulers.parallel())
                    .subscribe(eventHandler -> LOG.debug(LOG_MSG, eventHandler.getClass().toString()));

        } catch (Exception t) {
            LOG.info(t.getMessage());
            LOG.error("[EventBus] Could not associated handler for: {}", eventName);
        }
    }
}
