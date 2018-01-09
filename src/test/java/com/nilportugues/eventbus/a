package com.nilportugues.eventbus.kafka_avro;

import java.util.Properties;

public class KafkaTestConfig {

    public static Properties buildProducerProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "52.2.239.144:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("compression.type", "gzip");
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        return props;
    }

    public static Properties buildConsumerProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "ec2-52-2-239-144.compute-1.amazonaws.com:9092");
        props.put("group.id", "events");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        return props;
    }
}
