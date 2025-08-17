package com.springbootbasics.store.repositories;

import com.springbootbasics.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
