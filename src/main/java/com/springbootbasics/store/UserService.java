package com.springbootbasics.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    //properties:
    private final NotificationService notificationService;
    private final UserRepository userRepository;

    //CONSTRUCTOR:
    public UserService(NotificationService notificationService,  UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

    //methods:
    public void registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists with email: " + user.getEmail());
        }

        userRepository.save(user);
        notificationService.send("You registered successfully!", user.getEmail());
    }
}
