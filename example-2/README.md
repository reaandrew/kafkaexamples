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

4. Get the list of current brokers from docker

This is only one way of getthing this information.  Another way would be to write small script and enumerate the keys inside zookeeper to get the endpoints.  Since this example is using `docker-compose`, the following one line gets the job done.

```
export BROKERS=$(docker-compose ps kafka | tail -n +3 | tr -s ' ' | cut -d' ' -f4 | cut -d'-' -f1 | paste -sd ',')
```

5. Start three consumers

 - Inside three separate terminals (terminal 1, 2 and 3) invoke the `kafka-console-consumer.sh`.  

```
kafka-console-consumer.sh --bootstrap-server $BROKERS --group cg1 --topic test
```

6. Start the producer

Inside a fourth terminal (terminal 4) invoke the `kafka-console-producer.sh` and send several messages.

```
kafka-console-producer.sh --broker-list $BROKERS --topic test
> message 1
> message 2
> message 3
```

7. Confirm the output in consumer terminals

- You should see `message 1` output inside consumer terminal 1.
- You should see `message 2` output inside consumer terminal 2.
- You should see `message 2` output inside consumer terminal 3.

**NB://** The reason why each of the messages are being distributed to each of the consumers is because the `kafka-console-consumer` will be using a `partition.assignment.strategy` of `roundrobin`.
