package com.restaurant.repository;

import com.restaurant.model.UserLogin;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<UserLogin, String> {

}

