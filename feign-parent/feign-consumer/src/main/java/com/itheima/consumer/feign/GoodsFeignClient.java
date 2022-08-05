package com.itheima.consumer.feign;

import com.itheima.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "FEIGN-PROVIDER")
public interface GoodsFeignClient {

    @GetMapping("/goods/findOne/{id}")
    Goods findGoodsById(@PathVariable("id") int id);

}
