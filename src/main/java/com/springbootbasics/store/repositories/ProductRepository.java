package com.springbootbasics.store.repositories;

import com.springbootbasics.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    //String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    //Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);

    //null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //multiple conditions
    List<Product> findByDescriptionNullAndNameNull();

    //Sort order by
    List<Product> findByNameOrderByPriceAsc(String name);

    //limits top/first
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    //find all products whose prices are in a given range and sort by name
    //@Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    //@Query(value = "select p from Product p where p.price between :min and :max order by p.name", nativeQuery = false) //using jpql

    @Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
    List<Product> findProduct(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying //need to use this if we're modifying anything
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void udpatePriceByCategory(BigDecimal newPrice, Byte categoryId);
}
