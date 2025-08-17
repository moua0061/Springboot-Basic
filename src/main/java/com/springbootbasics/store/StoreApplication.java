package com.springbootbasics.store;

import com.springbootbasics.store.entities.Address;
import com.springbootbasics.store.entities.Profile;
import com.springbootbasics.store.entities.Tag;
import com.springbootbasics.store.entities.User;
import com.springbootbasics.store.repositories.UserRepository;
import com.springbootbasics.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args); //for beans
        var service = context.getBean(UserService.class);
        service.deleteRelated();
        //service.persistRelated();
        //service.fetchAddress();
        //service.showRelatedEntities();
        //service.showEntityStates();
        //var repository = context.getBean(UserRepository.class);
        //var user = repository.findById(1L).orElseThrow();
        //repository.delete(user);
        //repository.findAll().forEach(u -> System.out.println(u.getEmail()));
        //System.out.println(user);
//        var users = User.builder()
//                .name("John")
//                .email("john@gmail.com")
//                .password("password")
//                .build();
//        repository.save(users);
        //var user = new User();
        //var user = User.builder().name("John").password("123").build();
//        var address = Address.builder()
//                .street("123 Main St")
//                .city("123 Main St")
//                .state("123 Main St")
//                .zip("123 Main St")
//                .build();
//        user.addAddress(address);
//        var tag = new Tag("tag1");
//        user.getTags().add(tag);
//        tag.getUsers().add(user);
        //user.addTag("tag1");
//        var profile = Profile.builder()
//                        .bio("bio")
//                        .build();
//        user.setProfile(profile);
//        profile.setUser(user);
//        System.out.println(user);

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
