# EventBus 

There are 3 classes that make up this EventBus 

- **EventBus**: Given an event, it will dispatch it to a queue.
- **EventPublisher**: Interface that allows implementations handling the store of the events in a queue.
- **EventSubscriber**: This class registers event handlers to events. When a message is consumed, event handlers will be called.

## Installation

Add in your `pom.xml` file the jitpack.io repositories:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
  
Now add the package as a dependency: 

```xml
<dependencies>		
  <dependency>
    <groupId>com.nilportugues</groupId>
    <artifactId>eventbus</artifactId>
    <version>${eventbus.version}</version>
  </dependency>
</dependencies>  
```

## Support

Get in touch with me using one of the following means:

 - Emailing me at <contact@nilportugues.com>
 - Opening an [Issue](/../../issues/new)

## Authors

* [Nil Portugués Calderó](https://nilportugues.com)
* [The Community Contributors](/../../graphs/contributors)


## License
The code base is licensed under the [MIT license](LICENSE).
