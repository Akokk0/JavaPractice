package com.akokko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq.xml")
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleMode() {
        rabbitTemplate.convertAndSend("spring_queue", "hello rabbit spring...");
    }

    @Test
    public void testFanoutMode() {
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "fanout rabbit spring...");
    }

    @Test
    public void testTopicMode() {
        rabbitTemplate.convertAndSend("spring_topic_exchange", "heima.hehe.haha", "topic rabbit spring...");
    }
}
