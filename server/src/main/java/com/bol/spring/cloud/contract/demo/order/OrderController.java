package com.bol.spring.cloud.contract.demo.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping(path = "/orders/{id}", produces = "application/json")
    public Order getOrderById(@PathVariable("id") String id) {
        if ("666".equals(id)) throw new RuntimeException("Illegal order number, you devil!");
        return "0".equals(id) ? null : new Order(id);
    }
}
