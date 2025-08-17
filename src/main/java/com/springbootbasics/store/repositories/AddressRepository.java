package com.springbootbasics.store.repositories;

import com.springbootbasics.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
