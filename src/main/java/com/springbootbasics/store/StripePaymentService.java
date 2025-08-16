package com.springbootbasics.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {
    //PROPERTIES:
    @Value("${stripe.apiUrl}") //shortcut = control+space
    private String url;

    @Value("${stripe.enabled}")
    private boolean enabled;

    //can use stripe.timeout:3000 as a default value if the key isn't defined in app.properties
    //but the value in app.properties will override the value here if we defined it stripe.timeout:3000
    @Value("${stripe.timeout}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    //METHODS:
    @Override
    public void processPayment(double amount){
        //apiUrl
        //apiKey
        System.out.println("STRIPE");
        System.out.println("API URL: " + url);
        System.out.println("Enabled: " + enabled);
        System.out.println("Timeout:" + timeout);
        System.out.println("Currencies:" + supportedCurrencies);
        System.out.println("Amount:" + amount);
    }
}
