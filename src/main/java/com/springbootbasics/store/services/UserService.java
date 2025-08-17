package com.springbootbasics.store.services;

import com.springbootbasics.store.entities.User;
import com.springbootbasics.store.repositories.ProfileRepository;
import com.springbootbasics.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;

    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("john")
                .email("john@email.com")
                .password("password")
                .build();
        if(entityManager.contains(user)){
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }
    }

    @Transactional
    public void showRelatedEntities(){
        //var user = userRepository.findById(2L).orElseThrow();
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
        //System.out.println(profile.getBio());
    }
}
