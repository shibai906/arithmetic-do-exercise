package com.zhao.kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-18 23:29
 **/
public class KafkaProducerAnalysis {

    private static ExecutorService executor = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";

    public static Properties initConfig() {
        Properties prop = new Properties();
        prop.put("bootstrap.servers",brokerList);
        return prop;
    }

    public static void main(String[] args) {
        consumer();

//        for(int i = 0 ; i < 100 ; i ++) {
//            executor.execute(() -> producer());
//        }
//
//        executor.execute(() -> consumer());
    }

    public static void producer() {
        Properties props = initConfig();
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer",StringSerializer.class);
        KafkaProducer<String,String> producer = new KafkaProducer<>(props);
        ProducerRecord<String,String> record = new ProducerRecord<>(topic,"Hello,Kafka");
        producer.send(record);
    }

    public static void consumer() {
        Properties props = initConfig();
        // 制定消费组
        props.put("group.id","test");
        props.put("key.deserializer", StringDeserializer.class);
        props.put("value.deserializer",StringDeserializer.class);
        // 创建消费者实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(props);
        // 订阅topic1的消息
        consumer.subscribe(Arrays.asList(topic));
        while(true) {
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,String> record : records) {
                System.out.println("key:" + record.key() + ", value:" + record.value());
            }
        }

    }

}
