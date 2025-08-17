package com.springbootbasics.store.services;

import com.springbootbasics.store.entities.Address;
import com.springbootbasics.store.entities.User;
import com.springbootbasics.store.repositories.AddressRepository;
import com.springbootbasics.store.repositories.ProfileRepository;
import com.springbootbasics.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

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

    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated(){
        var user =  User.builder()
                .name("john")
                .email("email@gmail.com")
                .password("password")
                .build();
        var address = Address.builder()
                .street("123 street")
                .city("city")
                .state("state")
                .zip("12345")
                .build();
        user.addAddress((address));
        userRepository.save(user);
        addressRepository.save(address);
    }

    @Transactional
    public void deleteRelated(){
        //userRepository.deleteById(14L);
        var user = userRepository.findById(13L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }
}
