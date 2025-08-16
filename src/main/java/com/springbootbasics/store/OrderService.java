package com.springbootbasics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class OrderService {
    //properties:
    private PaymentService paymentService;

    //public OrderService(PaymentService paymentService, int x){}

    //constructor:
    //@Autowired
    public OrderService(PaymentService paymentService) {
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
    public void placeOrder(){
        //var paymentService = new StripePaymentService();
        paymentService.processPayment(10);
    }
}
