
## Examples

### Setup

#### Fetch the kafka tools from the kafka distribution.

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

#### Install Gradle

Download the gradle zip and unzip it
```
curl -L -o ~/gradle-4.5-bin.zip wget https://services.gradle.org/distributions/gradle-4.5-bin.zip
unzip ~/gradle-4.5-bin.zip -d ~/
```

Place the following line inside your rc file

```
export PATH=~/gradle-4.5/bin:$PATH
```

Finally source the file to update the PATH.

```
source ~/.bashrc
```


#### Build the sample Producer and Consumer tools

The source for these tools in this respository was taken from the javaworld[^1] article reference at the bottom of this post.

Build the source code

```
mkdir -p bin
gradle build

```


### Step 1: Single kafka node

- A single producer and a single consumer
- One partition as there is only one node

1. Start the cluster

```
docker-compose up -d
```

2. Create the topic



## References

[^1]: [https://www.javaworld.com/article/3060078/big-data/big-data-messaging-with-kafka-part-1.html?page=2](https://www.javaworld.com/article/3060078/big-data/big-data-messaging-with-kafka-part-1.html?page=2)

[https://github.com/wurstmeister/kafka-docker](https://github.com/wurstmeister/kafka-docker)

[https://stackoverflow.com/questions/38583608/connecting-to-zookeeper-in-a-apache-kafka-multi-node-cluster](https://stackoverflow.com/questions/38583608/connecting-to-zookeeper-in-a-apache-kafka-multi-node-cluster)
