package com.springbootbasics.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service
public class OrderService {
    //properties:
    private PaymentService paymentService;

    //public OrderService(PaymentService paymentService, int x){}

    //constructor:
    //@Autowired
    public OrderService(PaymentService paymentService) {
        System.out.println("Order service created");
        this.paymentService = paymentService;
    }

    //setters:
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //getters:
    public PaymentService getPaymentService() {
        return paymentService;
    }

    //METHODS:
    @PostConstruct //bean life cycle hooks; called after initialization
    public void init(){
        System.out.println("Order service PostConstructed");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Order service PreDestroyed");
    }

    public void placeOrder(){
        //var paymentService = new StripePaymentService();
        paymentService.processPayment(10);
    }
}
