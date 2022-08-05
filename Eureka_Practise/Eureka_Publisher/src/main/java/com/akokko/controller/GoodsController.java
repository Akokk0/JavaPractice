package com.akokko.controller;

import com.akokko.domain.Goods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("findById/{id}")
    public Goods findById(@PathVariable("id") Integer id) {
        return new Goods(id, "Apple Sillicon", 7199.00);
    }
}
