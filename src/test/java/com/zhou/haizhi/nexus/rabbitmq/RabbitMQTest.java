package com.zhou.haizhi.nexus.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Create by zhoumingbing on 2020-02-12
 */
public class RabbitMQTest implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
