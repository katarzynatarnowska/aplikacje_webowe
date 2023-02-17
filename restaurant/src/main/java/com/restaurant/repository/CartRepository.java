package com.restaurant.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.model.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}

