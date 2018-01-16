package com.bol.spring.cloud.contract.demo.order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerIT {

    @Autowired
    private OrderController orderController;

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
