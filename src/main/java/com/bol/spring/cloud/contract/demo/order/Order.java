package com.bol.spring.cloud.contract.demo.order;

public class Order {
    private String id;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}