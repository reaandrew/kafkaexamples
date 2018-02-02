# Example 2 - Multiple Kafka nodes with a single partition


TODO:

- Create a single consumer and publish 3 messages
- Create two consumers and publish 3 messages
- Create three consumers and publish 3 messages
- Create four consumers and publish 3 messages
- Create four consumers, public 3 messages, destroy a consumer and publish another
3 messages


1. Start the cluster

```
cd example-2
docker-compose up -d
```

2. Create the topic

```
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic test
```

3. Get the list of current brokers from docker

This is only one way of getthing this information.  Another way would be to
write small script and enumerate the keys inside zookeeper to get the endpoints.
Since this example is using `docker-compose`, the following one line gets the
job done.

```
export BROKERS=$(docker-compose ps kafka | tail -n +3 | tr -s ' ' | cut -d' ' -f4 | cut -d'-' -f1 | paste -sd ',')
```

4. Start the consumer

Inside a terminal (terminal 1) invoke the `kafka-console-consumer.sh`.  

```
kafka-console-consumer.sh --bootstrap-server $BROKERS --group cg1 --topic test
```

5. Start the producer

Inside a second terminal (terminal 2) invoke the `kafka-console-producer.sh` and send several messages.

```
kafka-console-producer.sh --broker-list $BROKERS --topic test
> message 1
> message 2
> message 3
```

6. Confirm the output in consumer terminal (terminal 1)

You should see the following output inside the consumer terminal.

```
message 1
message 2
message 3
```