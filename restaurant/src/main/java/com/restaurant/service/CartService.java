package com.restaurant.service;

import com.restaurant.model.Cart;
import com.restaurant.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }

    public void cartDeleteAll() {
        cartRepository.deleteAll();
    }
}
