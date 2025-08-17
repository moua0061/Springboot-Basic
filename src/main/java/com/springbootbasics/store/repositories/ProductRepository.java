package com.springbootbasics.store.repositories;

import com.springbootbasics.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
