# Example 2 - Multiple Kafka nodes with multiple partitions

Set up three kafka nodes with a single zookeeper node, creates a topic with three paritions, uses three different consumers and a single producer to send and receive several messages.  This example shows how consumers can be automatically distributed to a separate partition.

1. Start the cluster

```
cd example-2
docker-compose up -d
```

2. Scale out the cluster to three nodes

```
docker-compose scale kafka=3
```

3. Create the topic

```
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic test
```

4. Start three consumers

 - Inside three separate terminals (terminal 1, 2 and 3) invoke the `kafka-console-consumer.sh`.  

```
kafka-console-consumer.sh --bootstrap-server $BROKERS --group cg1 --topic test
```

5. Start the producer

Inside a fourth terminal (terminal 4) invoke the `kafka-console-producer.sh` and send several messages.

```
kafka-console-producer.sh --broker-list $BROKERS --topic test
> message 1
> message 2
> message 3
```

6. Confirm the output in consumer terminals

- You should see `message 1` output inside consumer terminal 1.
- You should see `message 2` output inside consumer terminal 2.
- You should see `message 2` output inside consumer terminal 3.

**NB://** The reason why each of the messages are being distributed to each of the consumers is because the `kafka-console-consumer` will be using a `partition.assignment.strategy` of `roundrobin`.
