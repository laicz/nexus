package com.zhou.haizhi.nexus.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Create by zhoumingbing on 2020-01-04
 */
public class KafkaConsumerTest {
    private static final String TOPIC_TEST = "test1";
    private KafkaConsumer<String, String> kafkaConsumer;

    @Before
    public void init() {
        Properties kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "60.205.176.135:9091,60.205.176.135:9092,60.205.176.135:9093");
        kafkaProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProperties.put("max.poll.records", "10000");
        kafkaProperties.put("group.id", "group_test");
        kafkaProperties.put("fetch.max.wait.ms", "1");
        kafkaConsumer = new KafkaConsumer<>(kafkaProperties);
    }

    @Test
    public void consumerMessage() {
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC_TEST));
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(10));
                consumerRecords.forEach(consumerRecord -> {
                    System.out.println(consumerRecord.value());
                });
                //异步提交偏移量
                kafkaConsumer.commitAsync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //同步提交偏移量
            kafkaConsumer.commitSync();
            kafkaConsumer.close();
        }
    }

    /**
     * 消费消息并提交特定的偏移量
     */
    @Test
    public void consumerAndCommitPositionOffset() {
        long counter = 0L;
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(10));
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    counter++;
                    System.out.println();
                    //每1000条数据提交一次偏移量，并指定偏移量
                    if (counter % 1000 == 0) {
                        Map<TopicPartition, OffsetAndMetadata> concurrentOffsetMap = new HashMap<>();
                        concurrentOffsetMap.put(new TopicPartition(consumerRecord.topic(), consumerRecord.partition()),
                                new OffsetAndMetadata(consumerRecord.offset() + 1));
                        kafkaConsumer.commitSync(concurrentOffsetMap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //同步提交偏移量
            kafkaConsumer.commitSync();
            kafkaConsumer.close();
        }
    }

    @Test
    public void rebalance() throws InterruptedException {
        Properties kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "60.205.176.135:9091,60.205.176.135:9092,60.205.176.135:9093");
        kafkaProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProperties.put("max.poll.records", "10000");
        kafkaProperties.put("group.id", "group_test");
        kafkaProperties.put("fetch.max.wait.ms", "1");
        kafkaConsumer = new KafkaConsumer<>(kafkaProperties);
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC_TEST), new ConsumerRebalanceListener() {
            /**
             * 该方法会在再均衡之前，消费者停止读取消息之后被调用
             * @param partitions
             */
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                System.out.println("will rebalance ...");
            }

            /**
             * 该方法会在再均衡完成之后，消费者重新开始读取消息之前被调用
             * @param partitions
             */
            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                System.out.println("rebalance has done ...");
            }
        });
        TimeUnit.SECONDS.sleep(1000L);
    }
}
