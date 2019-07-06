package com.pets.order.interfaces.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebEndpoint(id = "orders")
@Slf4j
@RestController
public class GetOrderController {


    @ReadOperation
    @GetMapping("/orders")
    public void getOrders() {

        long leftLimit = 100L;
        long rightLimit = 1000L;
        long latency = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

        try {
            Thread.sleep(latency);
        } catch (InterruptedException e) {
            log.error("Responding orders" + e.getMessage());
        }

        log.info("Responding orders latency [" + latency + "]");
        log.info("Responding orders...");

    }
}
