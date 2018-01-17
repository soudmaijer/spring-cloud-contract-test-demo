package com.bol.spring.cloud.contract.demo;

import com.bol.spring.cloud.contract.demo.order.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@RestController
public class ClientController {

    private final RestTemplate restTemplate;
    private final UriTemplateHandler uri;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.uri = restTemplate.getUriTemplateHandler();
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index(@RequestParam(value = "id", required = false) String id) {
        try {
            if (id == null) {
                return "<html><body><h1>Hello!</h1>Please specify the ?id= queryParameter!</body></html>";
            }
            return "<html><body><h1>Hello!</h1>Your order data: " + getOrderDetails(id) + "</body></html>";
        } catch (Exception e) {
            return "<html><body><h1>Failed!</h1>Error: " + e.getMessage() + "</body></html>";
        }
    }

    private String getOrderDetails(String id) {
        ResponseEntity<Order> response = restTemplate.getForEntity(uri.expand("/orders/{id}", id), Order.class);
        return response.hasBody() ? response.getBody().toString() : "Nothing found";
    }
}