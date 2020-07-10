package com.zhou.haizhi.nexus.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Create by zhoumingbing on 2020-01-04
 */
public class KafkaProducerTest {
    private static final String TOPIC_TEST = "test";
    private KafkaProducer<String, String> kafkaProducer;

    @Before
    public void init() {
        Properties kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "60.205.176.135:9091,60.205.176.135:9092,60.205.176.135:9093");
        kafkaProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<>(kafkaProperties);
    }

    /**
     * 发送消息并忘记，虽然会进行重试，但是还是会丢失数据而客户端并不知道
     */
    @Test
    public void sendMessageAndForget() {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_TEST, "test_message", "this test message");
        kafkaProducer.send(producerRecord);
    }

    /**
     * 同步发送消息，通过send方法获取到future,当发送失败后，get()方法会返回异常
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void sendMessageWithSync() throws ExecutionException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 2000; j++) {
                        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_TEST, "test_message", "this test message with sync" + j);
                        Future<RecordMetadata> future = kafkaProducer.send(producerRecord);
                        RecordMetadata recordMetadata = null;
                        try {
                            recordMetadata = future.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        System.out.println("record offset:" + recordMetadata.offset());
                    }
                    countDownLatch.countDown();
                }
            }));
        }
        threads.forEach(Thread::start);
        countDownLatch.await();
        System.out.println("send over......");
    }

    /**
     * 异步发送消息，通过在send方法中，增加一个回调函数，能够知道发送结果
     *
     * @throws InterruptedException
     */
    @Test
    public void sendMessageWithAsync() throws InterruptedException {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_TEST, "test_message", "this test message with async");
        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                System.out.println(metadata.offset());
            }
        });
        TimeUnit.SECONDS.sleep(3);
    }
}
