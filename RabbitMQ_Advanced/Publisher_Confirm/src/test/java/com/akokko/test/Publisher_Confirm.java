package com.akokko.test;

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
public class Publisher_Confirm {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test_confirm() throws InterruptedException {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             *
             * @param correlationData 参数信息
             * @param ack 交换机是否成功收到消息，成功收到返回true，否则返回false
             * @param cause 原因，成功或失败的原因
             */
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("回调函数执行了！！！");

                if (ack) {
                    // 消息发送成功
                    System.out.println("消息发送成功");
                    System.out.println(cause);
                } else {
                    // 消息发送失败
                    System.out.println("消息发送失败");
                    System.out.println(cause);
                }
            }
        });

        rabbitTemplate.convertAndSend("confirm_exchange", "confirm", "hello rabbit confirm...");
        Thread.sleep(200);
    }

    @Test
    public void test_return() throws InterruptedException {
        // 设置发送消息到队列失败调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             *
             * @param message 消息对象
             * @param i 错误码
             * @param s 错误信息
             * @param s1 交换机名称
             * @param s2 路由键
             */
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                System.out.println("return方法执行了...");
                System.out.println(message);
                System.out.println(i);
                System.out.println(s);
                System.out.println(s1);
                System.out.println(s2);
            }
        });

        rabbitTemplate.convertAndSend("confirm_exchange", "confirm", "hello rabbit confirm...");
        Thread.sleep(200);
    }
}
