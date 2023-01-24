package com.restaurant.repository;

//import com.restaurant.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.model.User;
//import com.restaurant.model.UserLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);

}

