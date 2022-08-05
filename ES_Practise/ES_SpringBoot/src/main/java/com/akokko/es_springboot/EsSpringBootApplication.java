package com.akokko.es_springboot;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsSpringBootApplication {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public static void main(String[] args) {
        SpringApplication.run(EsSpringBootApplication.class, args);
    }

}
