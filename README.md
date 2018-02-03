# Kafka Examples

## Setup

The following setup actions are required to follow the examples.

### Fetch the kafka tools from the kafka distribution.

Download the kafka distribution which contains a set of tools, some of which will be used in this series.

```
curl -L -o ~/kafka_2.11-1.0.0.tgz http://apache.mirror.anlx.net/kafka/1.0.0/kafka_2.11-1.0.0.tgz
tar -zxvf ~/kafka_2.11-1.0.0.tgz --directory ~/
```

Place the following line inside your rc file (e.g. .bashrc)

```
export PATH=~/kafka_2.11-1.0.0/bin:$PATH
```

Finally source the file to update the PATH.

```
source ~/.bashrc
```

### Fetch the zookeeper tools from the zookeeper distribution

Download the zookeeper distribution which contains a set of tools, some of which
will be used in this series.

```
curl -L -o ~/zookeeper-3.4.10.tar.gz http://apache.mirror.anlx.net/zookeeper/stable/zookeeper-3.4.10.tar.gz
tar -zxvf ~/zookeeper-3.4.10.tar.gz --directory ~/
```

Place the following line inside your rc file (e.g. .bashrc)

```
export PATH=~/zookeeper-3.4.10/bin:$PATH
```

Finally source the file to update the PATH

```
source ~/.bashrc
```

### Setting the host IP

In order to scale kafka locally an IP address of the host (which is not 127.0.0.1, 0.0.0.0 or localhost) is required.  Replace the value below to match your setup.  Plase the following inside your rc file.

```
export HOST="192.168.99.45"
```

## [Example 1: Single kafka node](example-1)

Set up a single kafka node with a single zookeeper node, creates a topic and then uses the kafka consumer and producer (supplied in the kafka distribution) to send and receive several messages.

## [Example 2 - Multiple Kafka nodes with multiple partitions](example-2)

Set up three kafka nodes with a single zookeeper node, creates a topic with three paritions, uses three different consumers and a single producer to send and receive several messages.  This example shows how consumers can be automatically distributed to a separate partition.

## References

[https://www.javaworld.com/article/3060078/big-data/big-data-messaging-with-kafka-part-1.html?page=2](https://www.javaworld.com/article/3060078/big-data/big-data-messaging-with-kafka-part-1.html?page=2)

[https://github.com/wurstmeister/kafka-docker](https://github.com/wurstmeister/kafka-docker)

[https://stackoverflow.com/questions/38583608/connecting-to-zookeeper-in-a-apache-kafka-multi-node-cluster](https://stackoverflow.com/questions/38583608/connecting-to-zookeeper-in-a-apache-kafka-multi-node-cluster)

[https://kafka.apache.org/quickstart](https://kafka.apache.org/quickstart)
