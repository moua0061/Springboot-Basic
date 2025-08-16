package com.springbootbasics.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

@Configuration
public class AppConfig {
    @Value("${payment-gateway}")
    private String paymentGateway;

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PayPalPaymentService();
    }

    @Bean
    //@Lazy //only use when needed like HeavyResource class annotated with the same annotation
    //@Scope("prototype")
    public OrderService orderService(){
        if(paymentGateway.equals("stripe")){
            return new OrderService(stripe());
        }
        return new OrderService(paypal());
    }
}
