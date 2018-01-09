# EventBus 

There are 3 classes that make up this EventBus 

- **EventBus**: Given an event, it will dispatch it to a queue.
- **EventPublisher**: Interface that allows implementations handling the store of the events in a queue.
- **EventSubscriber**: This class registers event handlers to events. When a message is consumed, event handlers will be called.

### Package dependencies

None.
