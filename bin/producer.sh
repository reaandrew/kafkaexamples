#! /bin/bash

export KAFKA_SERVERS="$HOST:9092"
java -jar ./producer/build/libs/producer-all.jar $@
