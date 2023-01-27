package com.restaurant.service;

import com.restaurant.model.User;

import java.util.List;


public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);

}
