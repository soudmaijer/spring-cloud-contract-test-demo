package com.bol.spring.cloud.contract.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableStubRunnerServer
public class ClientControllerIT {

    @Autowired
    private ClientController clientController;

    @Test
    public void indexPage() {
        String indexPage = clientController.index("1");
        Assert.assertTrue("response does not contain expected data", indexPage.contains("<html><body><h1>Hello!</h1>Your order data: Order{id='1'}</body></html>"));
    }
}
