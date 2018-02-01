# Example 1 - Single kafka node

The following example sets up a single kafka node with a single zookeeper node, creates a topic and then uses the kafka consumer and producer (supplied in the kafka distribution) to send and receieve several messages.

![single-kafka-node.gif](single-kafka-node.gif)

1. Start the cluster

```
docker-compose -f docker-compose-single-node.yml up -d
```

2. Create the topic

```
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```

3. Start the consumer

Inside a terminal (terminal 1) invoke the `kafka-console-consumer.sh`.  

```
kafka-console-consumer.sh --bootstrap-server $HOST:9092 --group cg1 --topic test
```

4. Start the producer

Inside a second terminal (terminal 2) invoke the `kafka-console-producer.sh` and send several messages.

```
kafka-console-producer.sh --broker-list $HOST:9092 --topic test
> message 1
> message 2
> message 3
```

5. Confirm the output in consumer terminal (terminal 1)

You should see the following output inside the consumer terminal.

```
message 1
message 2
message 3
```
