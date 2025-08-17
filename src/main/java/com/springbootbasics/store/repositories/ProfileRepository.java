package com.springbootbasics.store.repositories;

import com.springbootbasics.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
