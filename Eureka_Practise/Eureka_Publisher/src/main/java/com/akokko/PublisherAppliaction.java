package com.akokko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PublisherAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(PublisherAppliaction.class, args);
    }
}
