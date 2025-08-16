package com.springbootbasics.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService = context.getBean(OrderService.class);
        //var orderService = new OrderService(new PayPalPaymentService());
        //orderService.setPaymentService(new PayPalPaymentService());
        orderService.placeOrder();
    }

}
