package com.restaurant.repository;

import com.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {

    Product findById(int id);

    @Query("select s from Product s where s.name like %:keyword%")
    List<Product> findByKeyword(@Param("keyword") String keyword);



}
