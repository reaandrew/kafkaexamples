#! /bin/bash

export KAFKA_SERVERS="$HOST:9092"
java -jar ./consumer/build/libs/consumer-all.jar $@ 
