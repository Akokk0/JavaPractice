package com.akokko.bootpublisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootPublisherApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void test() {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "item.info", "boot topic rabbit");
    }
}
