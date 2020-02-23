package com.zhou.haizhi.nexus.kafka;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

/**
 * Create by zhoumingbing on 2020-01-05
 */
public class DemoRebalanceListener implements ConsumerRebalanceListener {
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
}
