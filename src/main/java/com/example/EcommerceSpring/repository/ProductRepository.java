package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This is a Custom Query Method using HQL.
    // http://localhost:1001/api/categories?minPrice=2500

    @Query("SELECT p FROM Product p where p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    // This is the raw SQL query
    @Query(value = "SELECT * FROM Product WHERE MATCH(name, description) AGAINST (:keyWord)", nativeQuery = true)
    List<Product> find(@Param("keyword") String keyword);

    @Query("SELECT p from Product p WHERE p.price > :minPrice AND p.brand = :brand")
    List<Product> findByBrandAndPrice(@Param("minPrice") double price, @Param("brand") String brandName);
}