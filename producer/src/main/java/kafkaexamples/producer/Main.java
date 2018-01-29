package kafkaexamples.producer;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Main{

  private static Scanner in; 

  public void main(String[] argv){

    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Enter message(type exit to quit)");

    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.99.45:9092");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer<String, String>(configProperties);
    String line = in.nextLine();
    while(!line.equals("exit")) {
      System.out.println("Sending message");
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
      producer.send(rec);
      line = in.nextLine();
    }
    in.close();
    producer.close();

  }
}
