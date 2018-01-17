package com.bol.spring.cloud.contract.demo.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderControllerTest {

    private OrderController orderController;

    @Before
    public void setup() {
        orderController = new OrderController();
    }

    @Test
    public void getOrderById() {
        Order order = orderController.getOrderById("1");
        Assert.assertEquals("1", order.getId());
    }

    @Test
    public void getNonExistingOrderById() {
        Assert.assertNull(orderController.getOrderById("0"));
    }
}