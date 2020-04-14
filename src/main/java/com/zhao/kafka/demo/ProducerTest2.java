package com.zhao.kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-19 14:52
 **/
public class ProducerTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //配置信息
        Properties props = new Properties();
        //kafka服务器地址
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //设置数据key和value的序列化处理类
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //创建生产者实例
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord record = new ProducerRecord<String, String>("topics2", "userName2", "lc2");
        //发送记录
        Future<RecordMetadata> future = producer.send(record, (a, b) -> {
            System.out.println(a);
            System.out.println(b);
        });
        RecordMetadata metadata = future.get();
        producer.close();
    }

}


//    //配置信息
//    Properties props = new Properties();
////kafka服务器地址
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//                //设置数据key和value的序列化处理类
//                props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        //创建生产者实例
//        KafkaProducer<String,String> producer = new KafkaProducer<>(props);
//        ProducerRecord record = new ProducerRecord<String, String>("topic1", "userName", "lc");
//
//        try {
//        producer.send(record);
////            //发送记录
////            Future<RecordMetadata> fu = producer.send(record,(a, b) -> {
////                if(b != null) {
////                    System.out.println(b.fillInStackTrace());
////                    System.out.println("出异常了");
////                } else {
////                    System.out.println("没有异常，气不气");
////                }
////            });
////            fu.get();
//        } finally {
//        producer.close();
//        }