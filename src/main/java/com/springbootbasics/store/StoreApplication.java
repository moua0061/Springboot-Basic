package com.springbootbasics.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args); //for beans
        //ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args); //gives me manually close the context
        //var manager = context.getBean(NotificationManager.class);
        //manager.sendNotification("This is a test");
        //var orderService = context.getBean(OrderService.class);

        //bean scope: singleton by default
        //var orderService2 = context.getBean(OrderService.class);
        //orderService.placeOrder();
        //var resource = context.getBean(HeavyResource.class);
        //var userService = context.getBean(UserService.class);
        //userService.registerUser(new User(1L, "email@email.com", "password", "Lia"));
        //userService.registerUser(new User(1L, "email@email.com", "password", "Lia"));
        //context.close(); //used during ConfigurableApplicationContext
    }

}
