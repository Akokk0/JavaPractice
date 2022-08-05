package com.akokko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq.xml")
public class test {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testConfirm() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("confirmCallback执行了...");
                if (ack) {
                    System.out.println("消息发送成功" + cause);
                } else {
                    System.out.println("消息发送失败" + cause);
                }
            }
        });
        rabbitTemplate.convertAndSend("confirm_exchange", "confirm", "hello rabbit confirm...");
    }

    @Test
    public void testReturn() {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                // 发送失败的消息
                System.out.printf("ReturnCallback执行了...");
            }
        });
        rabbitTemplate.convertAndSend("confirm_exchange", "confirm", "hello rabbit confirm...");
    }
}
