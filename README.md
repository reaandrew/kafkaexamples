# Kafka Examples

## Setup

The following setup actions are required to follow the examples.

### Fetch the kafka tools from the kafka distribution.

Download the kafka distribution which contain a set of tools, some of which will be used in this series.

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

### Setting the host IP

In order to scale kafka locally an IP address of the host (which is not 127.0.0.1, 0.0.0.0 or localhost) is required.  Replace the value below to match your setup.  Plase the following inside your rc file.

```
export HOST="192.168.99.45"
```

### Example 1: Single kafka node

Set up a single kafka node with a single zookeeper node, creates a topic and then uses the kafka consumer and producer (supplied in the kafka distribution) to send and receieve several messages.

[example-1](example-1)

