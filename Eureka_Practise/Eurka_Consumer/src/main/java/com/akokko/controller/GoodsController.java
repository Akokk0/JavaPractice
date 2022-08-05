package com.akokko.controller;

import com.akokko.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/findGoodsById/{id}")
    public Goods findGoodsById(@PathVariable("id") Integer id) {
        System.out.println("调用了findGoodsById...");

        List<ServiceInstance> eurekapublisher = discoveryClient.getInstances("EUREKAPUBLISHER");

        if (eurekapublisher == null || eurekapublisher.size() == 0) {
            return null;
        }

        ServiceInstance serviceInstance = eurekapublisher.get(0);

        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        String URL = "http://" + host + ":" + port + "/goods/findById/" + id;

        System.out.println(URL);

        Goods goods = restTemplate.getForObject(URL, Goods.class);

        return goods;
    }
}
